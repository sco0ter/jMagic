/*
 * MIT License
 *
 * Copyright (c) 2021 Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package mtgjson;

import static org.jooq.generated.Tables.CARD;
import static org.jooq.generated.Tables.CARD_AVAILABILITY;
import static org.jooq.generated.Tables.CARD_COLOR;
import static org.jooq.generated.Tables.CARD_COLOR_IDENTITY;
import static org.jooq.generated.Tables.CARD_COLOR_INDICATOR;
import static org.jooq.generated.Tables.CARD_FINISH;
import static org.jooq.generated.Tables.CARD_FRAME_EFFECT;
import static org.jooq.generated.Tables.FOREIGN_DATA;
import static org.jooq.generated.Tables.SET;
import static org.jooq.generated.Tables.SET_CARD;
import static org.jooq.generated.Tables.TOKEN_CARD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.sql.DataSource;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.core.H2Database;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.generated.tables.records.CardAvailabilityRecord;
import org.jooq.generated.tables.records.CardColorIdentityRecord;
import org.jooq.generated.tables.records.CardColorRecord;
import org.jooq.generated.tables.records.CardFinishRecord;
import org.jooq.generated.tables.records.CardFrameEffectRecord;
import org.jooq.generated.tables.records.CardRecord;
import org.jooq.generated.tables.records.ForeignDataRecord;
import org.jooq.generated.tables.records.SetCardRecord;
import org.jooq.generated.tables.records.SetRecord;
import org.jooq.generated.tables.records.TokenCardRecord;
import org.jooq.generated.tables.records.TokenCardReverseRelatedRecord;
import org.jooq.impl.DSL;

public final class DatabaseUtil {

    private final DataSource dataSource;

    public DatabaseUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void init() throws SQLException, LiquibaseException {

        try (Connection connection = dataSource.getConnection()) {

            Database database = new H2Database();
            database.setConnection(new JdbcConnection(connection));
            Liquibase liquibase =
                    new liquibase.Liquibase("databaseChangelog.xml", new ClassLoaderResourceAccessor(), database);
            liquibase.update(new Contexts(), new LabelExpression());
        }
    }

    public void insert(Set set) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            DSLContext context = DSL.using(connection, SQLDialect.DEFAULT);

            SetRecord setRecord = context.newRecord(SET, set);
            context.insertInto(SET).set(setRecord).execute();

            for (SetCard card : set.getCards()) {

                CardRecord cardRecord = context.newRecord(CARD, card);
                cardRecord.store();

                SetCardRecord setCardRecord = context.newRecord(SET_CARD, card);
                setCardRecord.setCardId(cardRecord.getId());
                setCardRecord.store();

                for (ForeignData foreignData : card.getForeignData()) {
                    ForeignDataRecord foreignDataRecord =
                            new ForeignDataRecord(null, cardRecord.getId(), foreignData.getFaceName(),
                                    foreignData.getFlavorText(), foreignData.getLanguage(),
                                    foreignData.getMultiverseId(), foreignData.getName(), foreignData.getText(),
                                    foreignData.getType());
                    foreignDataRecord.attach(context.configuration());
                    foreignDataRecord.store();
                }

                insertCard(card, context, cardRecord.getId());
            }

            for (TokenCard card : set.getTokens()) {

                CardRecord cardRecord = context.newRecord(CARD, card);
                cardRecord.store();

                TokenCardRecord tokenCardRecord = context.newRecord(TOKEN_CARD, card);
                tokenCardRecord.setCardId(cardRecord.getId());
                tokenCardRecord.store();

                insertCard(card, context, cardRecord.getId());

                for (String reverseRelated : card.getReverseRelated()) {
                    TokenCardReverseRelatedRecord tokenCardReverseRelatedRecord = new TokenCardReverseRelatedRecord(
                            null, cardRecord.getId(), reverseRelated);
                    tokenCardReverseRelatedRecord.attach(context.configuration());
                    tokenCardReverseRelatedRecord.store();
                }
            }
        }
    }

    private void insertCard(AbstractCard card, DSLContext context, Integer cardId) {
        for (Availability availability : card.getAvailabilities()) {
            CardAvailabilityRecord cardAvailabilityRecord = new CardAvailabilityRecord(null, cardId, availability);
            cardAvailabilityRecord.attach(context.configuration());
            cardAvailabilityRecord.store();
        }

        if (card.getFrameEffects() != null) {
            for (FrameEffect frameEffect : card.getFrameEffects()) {
                CardFrameEffectRecord cardFrameeffectRecord = new CardFrameEffectRecord(null, cardId, frameEffect);
                cardFrameeffectRecord.attach(context.configuration());
                cardFrameeffectRecord.store();
            }
        }

        for (Color color : card.getColors()) {
            CardColorRecord cardColorRecord = new CardColorRecord(null, cardId, color);
            cardColorRecord.attach(context.configuration());
            cardColorRecord.store();
        }

        for (Color color : card.getColorIdentity()) {
            CardColorIdentityRecord cardColorIdentityRecord = new CardColorIdentityRecord(null, cardId, color);
            cardColorIdentityRecord.attach(context.configuration());
            cardColorIdentityRecord.store();
        }

        for (Finish finish : card.getFinishes()) {
            CardFinishRecord cardFinishRecord = new CardFinishRecord(null, cardId, finish);
            cardFinishRecord.attach(context.configuration());
            cardFinishRecord.store();
        }
    }

    private static List<SetCard> recordsToSetCards(DSLContext dslContext, Stream<Record> records) {
        return records.map(r -> {
            java.util.Set<Availability> availabilities =
                    dslContext.selectDistinct(CARD_AVAILABILITY.AVAILABILITY)
                            .from(CARD_AVAILABILITY)
                            .where(CARD_AVAILABILITY.CARD_ID.eq(r.get(CARD.ID)))
                            .fetchSet(CARD_AVAILABILITY.AVAILABILITY);
            java.util.Set<Color> colorIdentities =
                    dslContext.selectDistinct(CARD_COLOR_IDENTITY.COLOR)
                            .from(CARD_COLOR_IDENTITY)
                            .where(CARD_COLOR_IDENTITY.CARD_ID.eq(r.get(CARD.ID)))
                            .fetchSet(CARD_COLOR_IDENTITY.COLOR);
            java.util.Set<Color> colorIndicators =
                    dslContext.selectDistinct(CARD_COLOR_INDICATOR.COLOR)
                            .from(CARD_COLOR_INDICATOR)
                            .where(CARD_COLOR_INDICATOR.CARD_ID.eq(r.get(CARD.ID)))
                            .fetchSet(CARD_COLOR_INDICATOR.COLOR);
            java.util.Set<Color> colors =
                    dslContext.selectDistinct(CARD_COLOR.COLOR)
                            .from(CARD_COLOR)
                            .where(CARD_COLOR.CARD_ID.eq(r.get(CARD.ID)))
                            .fetchSet(CARD_COLOR.COLOR);
            java.util.Set<FrameEffect> frameEffects =
                    dslContext.selectDistinct(CARD_FRAME_EFFECT.FRAME_EFFECT)
                            .from(CARD_FRAME_EFFECT)
                            .where(CARD_FRAME_EFFECT.CARD_ID.eq(r.get(CARD.ID)))
                            .fetchSet(CARD_FRAME_EFFECT.FRAME_EFFECT);
            java.util.Set<Finish> finishes =
                    dslContext.selectDistinct(CARD_FINISH.FINISH)
                            .from(CARD_FINISH)
                            .where(CARD_FINISH.CARD_ID.eq(r.get(CARD.ID)))
                            .fetchSet(CARD_FINISH.FINISH);
            java.util.Set<ForeignData> foreignData =
                    new HashSet<>(dslContext.selectFrom(FOREIGN_DATA)
                            .where(FOREIGN_DATA.CARD_ID.eq(r.get(CARD.ID)))
                            .fetchInto(ForeignData.class));
            return new SetCard(r.get(CARD.ARTIST), r.get(CARD.ASCII_NAME), availabilities,
                    r.get(CARD.BORDER_COLOR), colorIdentities, colorIndicators, colors,
                    r.get(CARD.EDHREC_RANK),
                    r.get(CARD.FACE_NAME), r.get(SET_CARD.FACE_MANA_VALUE), finishes,
                    r.get(SET_CARD.FLAVOR_NAME), r.get(CARD.FLAVOR_TEXT), foreignData, frameEffects,
                    r.get(CARD.FRAME_VERSION), r.get(SET_CARD.HAND), r.get(SET_CARD.HAS_CONTENT_WARNING),
                    r.get(SET_CARD.HAS_ALTERNATIVE_DECK_LIMIT),
                    null, r.get(SET_CARD.IS_ALTERNATIVE), r.get(CARD.IS_FULL_ART),
                    r.get(CARD.IS_ONLINE_ONLY), r.get(SET_CARD.IS_OVERSIZED), r.get(CARD.IS_PROMO),
                    r.get(CARD.IS_REPRINT), r.get(SET_CARD.IS_RESERVED), r.get(SET_CARD.IS_STARTER),
                    r.get(SET_CARD.IS_STORY_SPOTLIGHT), r.get(SET_CARD.IS_TEXTLESS),
                    r.get(SET_CARD.IS_TIMESHIFTED), null, r.get(CARD.LAYOUT), null, r.get(SET_CARD.LIFE),
                    r.get(CARD.LOYALTY), r.get(SET_CARD.MANA_COST), r.get(SET_CARD.MANA_VALUE),
                    r.get(CARD.NAME), r.get(CARD.NUMBER), null, r.get(SET_CARD.ORIGINAL_TEXT),
                    r.get(SET_CARD.ORIGINAL_TYPE), null, r.get(CARD.POWER), null, null,
                    r.get(SET_CARD.RARITY), null, r.get(CARD.SET_CODE), r.get(CARD.SIDE), null, null, null,
                    r.get(CARD.TOUGHNESS), r.get(CARD.TYPE), null, null, null, r.get(CARD.WATERMARK)
            );
        }).collect(Collectors.toList());
    }

    public List<SetCard> findCardsByName(String name) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {

            DSLContext dslContext = DSL.using(connection, SQLDialect.DEFAULT);
            return recordsToSetCards(dslContext, dslContext.select()
                    .from(SET_CARD)
                    .join(CARD)
                    .on(SET_CARD.CARD_ID.eq(CARD.ID))
                    .where(CARD.NAME.like(name))
                    .fetch().stream());
        }
    }

    public List<Set> findSets() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {

            DSLContext dslContext = DSL.using(connection, SQLDialect.DEFAULT);
            return dslContext.select()
                    .from(SET)
                    .fetch(r -> {
                        Stream<Record> records = dslContext.select()
                                .from(SET_CARD)
                                .join(CARD)
                                .on(SET_CARD.CARD_ID.eq(CARD.ID))
                                .where(CARD.SET_CODE.eq(r.get(SET.CODE)))
                                .fetch().stream();

                        java.util.List<SetCard> cards = recordsToSetCards(dslContext, records);
                        return new Set(r.get(SET.BASE_SET_SIZE),
                                r.get(SET.BLOCK),
                                r.get(SET.CODE),
                                r.get(SET.CODE_V3),
                                cards,
                                r.get(SET.IS_FOREIGN_ONLY),
                                r.get(SET.IS_FOIL_ONLY),
                                r.get(SET.IS_NON_FOIL_ONLY),
                                r.get(SET.IS_ONLINE_ONLY),
                                r.get(SET.IS_PAPER_ONLY),
                                r.get(SET.IS_PARTIAL_PREVIEW),
                                r.get(SET.KEYRUNE_CODE),
                                r.get(SET.MCM_ID),
                                r.get(SET.MCM_ID_EXTRAS),
                                r.get(SET.MCM_NAME),
                                r.get(SET.MTGO_CODE),
                                r.get(SET.NAME),
                                r.get(SET.RELEASE_DATE),
                                r.get(SET.PARENT_CODE),
                                r.get(SET.TCGPLAYER_GROUP_ID),
                                null,
                                r.get(SET.TOTAL_SET_SIZE),
                                null,
                                r.get(SET.TYPE)
                        );
                    });
        }
    }
}

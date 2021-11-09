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

import java.sql.Connection;
import java.sql.SQLException;
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
import org.jooq.SQLDialect;
import org.jooq.generated.Tables;
import org.jooq.generated.tables.records.CardAvailabilityRecord;
import org.jooq.generated.tables.records.CardColorIdentityRecord;
import org.jooq.generated.tables.records.CardColorRecord;
import org.jooq.generated.tables.records.CardFrameEffectRecord;
import org.jooq.generated.tables.records.CardRecord;
import org.jooq.generated.tables.records.SetCardRecord;
import org.jooq.generated.tables.records.SetRecord;
import org.jooq.generated.tables.records.TokenCardRecord;
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

            SetRecord setRecord = context.newRecord(Tables.SET, set);
            context.insertInto(Tables.SET).set(setRecord).execute();

            for (SetCard card : set.getCards()) {
                CardRecord cardRecord = context.newRecord(Tables.CARD, card);
                cardRecord.store();

                SetCardRecord setCardRecord = context.newRecord(Tables.SET_CARD, card);
                setCardRecord.setCardId(cardRecord.getId());
                setCardRecord.store();

                insertCard(card, context, cardRecord.getId());
            }

            for (TokenCard card : set.getTokens()) {

                CardRecord cardRecord = context.newRecord(Tables.CARD, card);
                cardRecord.store();

                insertCard(card, context, cardRecord.getId());

                for (String reverseRelated : card.getReverseRelated()) {
                    TokenCardRecord tokenCardRecord = new TokenCardRecord(null, cardRecord.getId(), reverseRelated);
                    tokenCardRecord.attach(context.configuration());
                    tokenCardRecord.store();
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
    }
}

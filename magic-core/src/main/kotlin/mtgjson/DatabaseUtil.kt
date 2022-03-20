/*
 * MIT License
 *
 * Copyright (c) 2022 Christian Schudt
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

package mtgjson

import liquibase.Contexts
import liquibase.LabelExpression
import liquibase.Liquibase
import liquibase.database.Database
import liquibase.database.core.H2Database
import liquibase.database.jvm.JdbcConnection
import liquibase.exception.LiquibaseException
import liquibase.resource.ClassLoaderResourceAccessor
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.SQLDialect
import org.jooq.generated.Tables
import org.jooq.generated.tables.records.*
import org.jooq.impl.DSL
import java.sql.SQLException
import java.util.stream.Collectors
import java.util.stream.Stream
import javax.sql.DataSource

class DatabaseUtil(private val dataSource: DataSource) {
    @Throws(SQLException::class, LiquibaseException::class)
    fun init() {
        dataSource.connection.use { connection ->
            val database: Database = H2Database()
            database.connection = JdbcConnection(connection)
            val liquibase = Liquibase("databaseChangelog.xml", ClassLoaderResourceAccessor(), database)
            liquibase.update(Contexts(), LabelExpression())
        }
    }

    @Throws(SQLException::class)
    fun insert(set: Set) {
        dataSource.connection.use { connection ->
            val context = DSL.using(connection, SQLDialect.DEFAULT)
            val setRecord = context.newRecord(Tables.SET, set)
            context.insertInto(Tables.SET).set(setRecord).execute()
            for (card in set.cards) {
                val cardRecord = context.newRecord(Tables.CARD, card)
                cardRecord.store()
                val setCardRecord = context.newRecord(Tables.SET_CARD, card)
                setCardRecord.cardId = cardRecord.id
                setCardRecord.store()
                for (foreignData in card.foreignData) {
                    val foreignDataRecord = ForeignDataRecord(
                        null, cardRecord.id, foreignData.faceName,
                        foreignData.flavorText, foreignData.language,
                        foreignData.multiverseId, foreignData.name, foreignData.text,
                        foreignData.type
                    )
                    foreignDataRecord.attach(context.configuration())
                    foreignDataRecord.store()
                }
                insertCard(card, context, cardRecord.id)
            }
            for (card in set.tokens!!) {
                val cardRecord = context.newRecord(Tables.CARD, card)
                cardRecord.store()
                val tokenCardRecord = context.newRecord(Tables.TOKEN_CARD, card)
                tokenCardRecord.cardId = cardRecord.id
                tokenCardRecord.store()
                insertCard(card, context, cardRecord.id)
                for (reverseRelated in card.reverseRelated) {
                    val tokenCardReverseRelatedRecord = TokenCardReverseRelatedRecord(
                        null, cardRecord.id, reverseRelated
                    )
                    tokenCardReverseRelatedRecord.attach(context.configuration())
                    tokenCardReverseRelatedRecord.store()
                }
            }
        }
    }

    private fun insertCard(card: AbstractCard, context: DSLContext, cardId: Int) {
        for (availability in card.availabilities) {
            val cardAvailabilityRecord = CardAvailabilityRecord(null, cardId, availability)
            cardAvailabilityRecord.attach(context.configuration())
            cardAvailabilityRecord.store()
        }
        for (frameEffect in card.frameEffects) {
            val cardFrameeffectRecord = CardFrameEffectRecord(null, cardId, frameEffect)
            cardFrameeffectRecord.attach(context.configuration())
            cardFrameeffectRecord.store()
        }
        for (color in card.colors) {
            val cardColorRecord = CardColorRecord(null, cardId, color)
            cardColorRecord.attach(context.configuration())
            cardColorRecord.store()
        }
        for (color in card.colorIdentity) {
            val cardColorIdentityRecord = CardColorIdentityRecord(null, cardId, color)
            cardColorIdentityRecord.attach(context.configuration())
            cardColorIdentityRecord.store()
        }
        for (finish in card.finishes) {
            val cardFinishRecord = CardFinishRecord(null, cardId, finish)
            cardFinishRecord.attach(context.configuration())
            cardFinishRecord.store()
        }
        val identifiers = card.identifiers
        val identifiersRecord = IdentifiersRecord(
            cardId, identifiers.cardKingdomFoilId,
            identifiers.cardKingdomId, identifiers.mcmId, identifiers.mcmMetaId,
            identifiers.mtgArenaId, identifiers.mtgoFoilId, identifiers.mtgoId,
            identifiers.mtgjsonV4Id, identifiers.multiverseId, identifiers.scryfallId,
            identifiers.scryfallOracleId, identifiers.scryfallIllustrationId,
            identifiers.tcgplayerProductId
        )
        identifiersRecord.attach(context.configuration())
        identifiersRecord.store()
    }

    @Throws(SQLException::class)
    fun findCardsByName(name: String?): List<SetCard> {
        dataSource.connection.use { connection ->
            val dslContext = DSL.using(connection, SQLDialect.DEFAULT)
            return recordsToSetCards(
                dslContext, dslContext.select()
                    .from(Tables.SET_CARD)
                    .join(Tables.CARD)
                    .on(Tables.SET_CARD.CARD_ID.eq(Tables.CARD.ID))
                    .where(Tables.CARD.NAME.like(name))
                    .fetch().stream()
            )
        }
    }

    @Throws(SQLException::class)
    fun findSets(): List<Set> {
        dataSource.connection.use { connection ->
            val dslContext = DSL.using(connection, SQLDialect.DEFAULT)
            return dslContext.select()
                .from(Tables.SET)
                .fetch { r: Record ->
                    val records = dslContext.select()
                        .from(Tables.SET_CARD)
                        .join(Tables.CARD)
                        .on(Tables.SET_CARD.CARD_ID.eq(Tables.CARD.ID))
                        .where(Tables.CARD.SET_CODE.eq(r.get(Tables.SET.CODE)))
                        .fetch().stream()
                    val cards =
                        recordsToSetCards(dslContext, records)
                    Set(
                        r.get(Tables.SET.BASE_SET_SIZE),
                        r.get(Tables.SET.BLOCK),
                        cards,
                        r.get(Tables.SET.CODE),
                        r.get(Tables.SET.CODE_V3),
                        r.get(Tables.SET.IS_FOREIGN_ONLY),
                        r.get(Tables.SET.IS_FOIL_ONLY),
                        r.get(Tables.SET.IS_NON_FOIL_ONLY),
                        r.get(Tables.SET.IS_ONLINE_ONLY),
                        r.get(Tables.SET.IS_PAPER_ONLY),
                        r.get(Tables.SET.IS_PARTIAL_PREVIEW),
                        r.get(Tables.SET.KEYRUNE_CODE),
                        r.get(Tables.SET.MCM_ID),
                        r.get(Tables.SET.MCM_ID_EXTRAS),
                        r.get(Tables.SET.MCM_NAME),
                        r.get(Tables.SET.MTGO_CODE),
                        r.get(Tables.SET.NAME),
                        r.get(Tables.SET.PARENT_CODE),
                        r.get(Tables.SET.RELEASE_DATE),
                        r.get(Tables.SET.TCGPLAYER_GROUP_ID),
                        null,
                        r.get(Tables.SET.TOTAL_SET_SIZE),
                        null,
                        r.get(Tables.SET.TYPE)
                    )
                }
        }
    }

    companion object {
        private fun recordsToSetCards(dslContext: DSLContext, records: Stream<Record>): List<SetCard> {
            return records.map { r: Record ->
                val availabilities =
                    dslContext.selectDistinct(Tables.CARD_AVAILABILITY.AVAILABILITY)
                        .from(Tables.CARD_AVAILABILITY)
                        .where(Tables.CARD_AVAILABILITY.CARD_ID.eq(r.get(Tables.CARD.ID)))
                        .fetchSet(Tables.CARD_AVAILABILITY.AVAILABILITY)
                val colorIdentities =
                    dslContext.selectDistinct(Tables.CARD_COLOR_IDENTITY.COLOR)
                        .from(Tables.CARD_COLOR_IDENTITY)
                        .where(Tables.CARD_COLOR_IDENTITY.CARD_ID.eq(r.get(Tables.CARD.ID)))
                        .fetchSet(Tables.CARD_COLOR_IDENTITY.COLOR)
                val colorIndicators =
                    dslContext.selectDistinct(Tables.CARD_COLOR_INDICATOR.COLOR)
                        .from(Tables.CARD_COLOR_INDICATOR)
                        .where(Tables.CARD_COLOR_INDICATOR.CARD_ID.eq(r.get(Tables.CARD.ID)))
                        .fetchSet(Tables.CARD_COLOR_INDICATOR.COLOR)
                val colors =
                    dslContext.selectDistinct(Tables.CARD_COLOR.COLOR)
                        .from(Tables.CARD_COLOR)
                        .where(Tables.CARD_COLOR.CARD_ID.eq(r.get(Tables.CARD.ID)))
                        .fetchSet(Tables.CARD_COLOR.COLOR)
                val frameEffects =
                    dslContext.selectDistinct(Tables.CARD_FRAME_EFFECT.FRAME_EFFECT)
                        .from(Tables.CARD_FRAME_EFFECT)
                        .where(Tables.CARD_FRAME_EFFECT.CARD_ID.eq(r.get(Tables.CARD.ID)))
                        .fetchSet(Tables.CARD_FRAME_EFFECT.FRAME_EFFECT)
                val finishes =
                    dslContext.selectDistinct(Tables.CARD_FINISH.FINISH)
                        .from(Tables.CARD_FINISH)
                        .where(Tables.CARD_FINISH.CARD_ID.eq(r.get(Tables.CARD.ID)))
                        .fetchSet(Tables.CARD_FINISH.FINISH)
                val foreignData: kotlin.collections.Set<ForeignData> = HashSet(
                    dslContext.selectFrom(Tables.FOREIGN_DATA)
                        .where(Tables.FOREIGN_DATA.CARD_ID.eq(r.get(Tables.CARD.ID)))
                        .fetchInto(ForeignData::class.java)
                )
                val identifiers = dslContext.selectFrom(Tables.IDENTIFIERS)
                    .where(Tables.IDENTIFIERS.CARD_ID.eq(r.get(Tables.CARD.ID)))
                    .fetchSingleInto(Identifiers::class.java)
                SetCard(
                    r.get(Tables.CARD.ARTIST),
                    r.get(Tables.CARD.ASCII_NAME),
                    availabilities,
                    r.get(Tables.CARD.BORDER_COLOR),
                    colorIdentities,
                    colorIndicators,
                    colors,
                    r.get(Tables.CARD.EDHREC_RANK),
                    r.get(Tables.CARD.FACE_NAME),
                    r.get(Tables.SET_CARD.FACE_MANA_VALUE),
                    finishes,
                    r.get(Tables.SET_CARD.FLAVOR_NAME),
                    r.get(Tables.CARD.FLAVOR_TEXT),
                    foreignData,
                    frameEffects,
                    r.get(Tables.CARD.FRAME_VERSION),
                    r.get(Tables.SET_CARD.HAND),
                    r.get(Tables.SET_CARD.HAS_CONTENT_WARNING),
                    r.get(Tables.SET_CARD.HAS_ALTERNATIVE_DECK_LIMIT),
                    identifiers,
                    r.get(Tables.SET_CARD.IS_ALTERNATIVE),
                    r.get(Tables.CARD.IS_FULL_ART),
                    r.get(Tables.CARD.IS_ONLINE_ONLY),
                    r.get(Tables.SET_CARD.IS_OVERSIZED),
                    r.get(Tables.CARD.IS_PROMO),
                    r.get(Tables.CARD.IS_REPRINT),
                    r.get(Tables.SET_CARD.IS_RESERVED),
                    r.get(Tables.SET_CARD.IS_STARTER),
                    r.get(Tables.SET_CARD.IS_STORY_SPOTLIGHT),
                    r.get(Tables.SET_CARD.IS_TEXTLESS),
                    r.get(Tables.SET_CARD.IS_TIMESHIFTED),
                    null,
                    r.get(Tables.CARD.LAYOUT),
                    null,
                    r.get(Tables.SET_CARD.LIFE),
                    r.get(Tables.CARD.LOYALTY),
                    r.get(Tables.SET_CARD.MANA_COST),
                    r.get(Tables.SET_CARD.MANA_VALUE),
                    r.get(Tables.CARD.NAME),
                    r.get(Tables.CARD.NUMBER),
                    null,
                    r.get(Tables.SET_CARD.ORIGINAL_TEXT),
                    r.get(Tables.SET_CARD.ORIGINAL_TYPE),
                    null,
                    r.get(Tables.CARD.POWER),
                    null,
                    null,
                    r.get(Tables.SET_CARD.RARITY),
                    null,
                    r.get(Tables.CARD.SET_CODE),
                    r.get(Tables.CARD.SIDE),
                    null,
                    null,
                    null,
                    r.get(Tables.CARD.TOUGHNESS),
                    r.get(Tables.CARD.TYPE),
                    null,
                    null,
                    null,
                    r.get(Tables.CARD.WATERMARK)
                )
            }.collect(Collectors.toList())
        }
    }
}
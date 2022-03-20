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

import com.fasterxml.jackson.annotation.JsonValue
import java.beans.ConstructorProperties
import java.time.LocalDate

class Set @ConstructorProperties(
    "baseSetSize",
    "block",
    "cards",
    "code",
    "codeV3",
    "isForeignOnly",
    "isFoilOnly",
    "isNonFoilOnly",
    "isOnlineOnly",
    "isPaperOnly",
    "isPartialPreview",
    "keyruneCode",
    "mcmId",
    "mcmIdExtras",
    "mcmName",
    "mtgoCode",
    "name",
    "parentCode",
    "releaseDate",
    "tcgplayerGroupId",
    "tokens",
    "totalSetSize",
    "translations",
    "type"
) constructor(

    /**
     * The number of cards in the set. Will default to totalSetSize if not available. Wizards of the Coast sometimes
     * prints extra cards beyond the set size into promos or supplemental products.
     *
     * @return The number of cards in the set.
     */
    val baseSetSize: Int,

    /**
     * The block name the set was in.
     *
     * @return The block name the set was in.
     */
    val block: String?,

    /**
     * The list of cards in the set. The returned list is unmodifiable.
     *
     * @return The list of cards in the set.
     * @see SetCard
     */
    val cards: List<SetCard>,

    /**
     * The set code for the set.
     *
     * @return The set code for the set.
     */
    val code: String,

    /**
     * The alternate set code Wizards of the Coast uses for a select few duel deck sets.
     *
     * @return The alternate set code Wizards of the Coast uses for a select few duel deck sets.
     */
    val codeV3: String?,

    isForeignOnly: Boolean?,

    /**
     * If the set is only available in foil.
     *
     * @return If the set is only available in foil.
     */
    val isFoilOnly: Boolean,

    isNonFoilOnly: Boolean?,

    /**
     * If the set is only available online.
     *
     * @return If the set is only available online.
     */
    val isOnlineOnly: Boolean,

    isPaperOnly: Boolean?,
    isPartialPreview: Boolean?,

    /**
     * The matching Keyrune code for [Keyrune](https://keyrune.andrewgioia.com/) image icons.
     *
     * @return The matching Keyrune code for Keyrune image icons.
     */
    val keyruneCode: String,

    /**
     * The [Magic Card Market](https://www.cardmarket.com/en/Magic) set identifier.
     *
     * @return The [Magic Card Market](https://www.cardmarket.com/en/Magic) set identifier.
     */
    val mcmId: Int?,

    /**
     * The split [Magic Card Market](https://www.cardmarket.com/en/Magic) set identifier if a set is printed
     * in two sets. This identifier represents the second set's identifier.
     *
     * @return The split [Magic Card Market](https://www.cardmarket.com/en/Magic) set identifier if a set is
     * printed in two sets.
     */
    val mcmIdExtras: Int?,

    /**
     * The [Magic Card Market](https://www.cardmarket.com/en/Magic) set name.
     *
     * @return The [Magic Card Market](https://www.cardmarket.com/en/Magic) set name.
     */
    val mcmName: String?,

    /**
     * The set code for the set as it appears on [Magic: The Gathering Online](https://magic.wizards.com/en/mtgo).
     *
     * @return The set code for the set as it appears on [Magic: The Gathering Online](https://magic.wizards.com/en/mtgo).
     */
    val mtgoCode: String?,

    /**
     * The name of the set.
     *
     * @return The name of the set.
     */
    val name: String,

    /**
     * The parent set code for set variations like promotions, guild kits, etc.
     *
     * @return The parent set code for set variations like promotions, guild kits, etc.
     */
    val parentCode: String?,

    /**
     * The release date for the set.
     *
     * @return The release date for the set.
     */
    val releaseDate: LocalDate,

    /**
     * The group identifier of the set on [TCGplayer](https://www.tcgplayer.com).
     *
     * @return The group identifier of the set on [TCGplayer](https://www.tcgplayer.com).
     */
    val tcgplayerGroupId: Int?,

    /**
     * The tokens available to the set. The returned list is unmodifiable.
     *
     * @return The tokens available to the set.
     */
    val tokens: List<TokenCard>?,

    /**
     * The total number of cards in the set, including promos and related supplemental products.
     *
     * @return The total number of cards in the set, including promos and related supplemental products.
     */
    val totalSetSize: Int,

    /**
     * The translated set name by language.
     *
     * @return The translated set name by language.
     */
    val translations: Translations?,

    /**
     * The expansion type of the set.
     *
     * @return The expansion type of the set.
     */
    val type: Type
) {

    /**
     * If the set is available only outside the United States of America.
     *
     * @return If the set is available only outside the United States of America.
     */
    val isForeignOnly: Boolean = isForeignOnly ?: false

    /**
     * If the set is only available in non-foil.
     *
     * @return If the set is only available in non-foil.
     */
    val isNonFoilOnly: Boolean = isNonFoilOnly ?: false

    /**
     * If the set is available only in paper.
     *
     * @return If the set is available only in paper.
     */
    val isPaperOnly: Boolean = isPaperOnly ?: false

    /**
     * If the set is still in preview (spoiled). Preview sets do not have complete data.
     *
     * @return If the set is still in preview (spoiled). Preview sets do not have complete data.
     */
    val isPartialPreview: Boolean = isPartialPreview ?: false

    enum class Type(@JsonValue val value: String) {
        ARCHENEMY("archenemy"),
        BOX("box"),
        COMMANDER("commander"),
        CORE("core"),
        DRAFT_INNOVATION("draft_innovation"),
        DUEL_DECK("duel_deck"),
        EXPANSION("expansion"),
        FROM_THE_VAULT("from_the_vault"),
        FUNNY("funny"),
        MASTERPIECE("masterpiece"),
        MASTERS("masters"),
        MEMORABILIA("memorabilia"),
        PLANECHASE("planechase"),
        PREMIUM_DECK("premium_deck"),
        PROMO("promo"),
        SPELLBOOK("spellbook"),
        STARTER("starter"),
        TOKEN("token"),
        TREASURE_CHEST("treasure_chest"),
        VANGUARD("vanguard");
    }

    override fun toString(): String {
        return "$name ($code)"
    }
}
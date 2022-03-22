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

import java.beans.ConstructorProperties
import java.time.LocalDate
import kotlin.collections.Set

open class SetCard @ConstructorProperties(
    "artist",
    "asciiName",
    "availability",
    "borderColor",
    "colorIdentity",
    "colorIndicator",
    "colors",
    "edhrecRank",
    "faceName",
    "faceManaValue",
    "finishes",
    "flavorName",
    "flavorText",
    "foreignData",
    "frameEffects",
    "frameVersion",
    "hand",
    "hasContentWarning",
    "hasAlternativeDeckLimit",
    "identifiers",
    "isAlternative",
    "isFullArt",
    "isOnlineOnly",
    "isOversized",
    "isPromo",
    "isReprint",
    "isReserved",
    "isStarter",
    "isStorySpotlight",
    "isTextless",
    "isTimeshifted",
    "keywords",
    "layout",
    "legalities",
    "life",
    "loyalty",
    "manaCost",
    "manaValue",
    "name",
    "number",
    "originalReleaseDate",
    "originalText",
    "originalType",
    "otherFaceIds",
    "power",
    "printings",
    "promoTypes",
    "rarity",
    "rulings",
    "setCode",
    "side",
    "subtypes",
    "supertypes",
    "text",
    "toughness",
    "type",
    "types",
    "uuid",
    "variations",
    "watermark"
) constructor(
    artist: String?,
    asciiName: String?,
    availabilities: Set<Availability>,
    borderColor: BorderColor,
    colorIdentity: Set<Color>?,
    colorIndicator: Set<Color>?,
    colors: Set<Color>,
    edhrecRank: Int?,
    faceName: String?,
    faceManaValue: Double?,
    finishes: Set<Finish>,

    /**
     * The promotional card name printed above the true card name on special cards that has no game function. See [this card](https://scryfall.com/card/plg20/2/hangarback-walker) for an example.
     *
     * @return The promotional card name printed above the true card name on special cards that has no game function.
     */
    val flavorName: String?,
    flavorText: String?,

    /**
     * A list of data properties in other languages.
     *
     * @return A list of data properties in other languages.
     */
    val foreignData: Set<ForeignData>,
    frameEffects: Set<FrameEffect>?,
    frameVersion: FrameVersion,
    /**
     * The starting maximum hand size total modifier. A + or - character precedes an integer.
     *
     * @return The starting maximum hand size total modifier.
     */
    val hand: String?,

    hasAlternativeDeckLimit: Boolean?,

    hasContentWarning: Boolean?,
    identifiers: Identifiers,
    isAlternative: Boolean?,
    isFullArt: Boolean?,
    isOnlineOnly: Boolean?,
    isOversized: Boolean?,
    isPromo: Boolean?,
    isReprint: Boolean?,
    isReserved: Boolean?,
    isStarter: Boolean?,
    isStorySpotlight: Boolean?,
    isTextless: Boolean?,
    isTimeshifted: Boolean?,
    keywords: List<String>?,
    layout: Layout,
    /**
     * A list of play formats the card the card is legal in.
     *
     * @return A list of play formats the card the card is legal in.
     */
    val legalities: Legalities?,
    /**
     * The starting life total modifier. A plus or minus character precedes an integer. Used only on cards with
     * "Vanguard" in its types.
     *
     * @return The starting life total modifier.
     */
    val life: String?,
    loyalty: String?,
    /**
     * The mana cost of the card.
     *
     * @return The mana cost of the card.
     */
    val manaCost: String?,
    /**
     * The mana cost of the card.
     *
     * @return The mana cost of the card.
     */
    val manaValue: Double,
    name: String,
    number: String,
    /**
     * The original release date for a promotional card printed outside of a cycle window, such as Secret Lair Drop
     * promotions.
     *
     * @return The original release date.
     */
    val originalReleaseDate: LocalDate?,
    /**
     * The text on the card as originally printed.
     *
     * @return The text on the card as originally printed.
     */
    val originalText: String?,
    /**
     * The type of the card as originally printed. Includes any supertypes and subtypes.
     *
     * @return The type of the card as originally printed. Includes any supertypes and subtypes.
     */
    val originalType: String?,

    /**
     * A list of UUID's of this card with counterparts, such as transformed or melded faces.
     *
     * @return A list of UUID's of this card with counterparts, such as transformed or melded faces.
     */
    val otherFaceIds: List<String>?,

    power: String?,

    /**
     * A list of set codes the card was printed in, formatted in uppercase.
     *
     * @return A list of set codes the card was printed in, formatted in uppercase.
     */
    val printings: List<String>?,

    promoTypes: List<String>?,
    /**
     * The card printing rarity.
     *
     * @return The card printing rarity.
     */
    val rarity: Rarity?,

    /**
     * The official rulings of the card. See the Rulings data model.
     *
     * @return The official rulings of the card. See the Rulings data model.
     */
    val rulings: List<Ruling>?,
    setCode: String,
    side: String?,
    subtypes: List<String>?,
    supertypes: List<String>?,
    text: String?,
    toughness: String?,
    type: String,
    types: List<String>?,
    uuid: String?,

    /**
     * A list of UUID's of this card with alternate printings in the same set. Excludes Un‑sets.
     *
     * @return A list of UUID's of this card with alternate printings in the same set. Excludes Un‑sets.
     */
    val variations: List<String>?,
    watermark: String?
) :
    AbstractCard(
        artist,
        asciiName,
        availabilities,
        borderColor,
        colorIdentity,
        colorIndicator,
        colors,
        edhrecRank,
        faceName,
        finishes,
        flavorText,
        frameEffects,
        frameVersion,
        identifiers,
        isFullArt,
        isOnlineOnly,
        isPromo,
        isReprint,
        keywords,
        layout,
        loyalty,
        name,
        number,
        power,
        promoTypes,
        setCode,
        side,
        subtypes,
        supertypes,
        text,
        toughness,
        type,
        types,
        uuid,
        watermark
    ) {

    /**
     * If the card allows a value other than 4 copies in a deck.
     *
     * @return If the card allows a value other than 4 copies in a deck.
     */
    @get:JvmName("hasAlternativeDeckLimit")
    val hasAlternativeDeckLimit: Boolean = hasAlternativeDeckLimit ?: false

    /**
     * If the card marked by Wizards of the Coast for having sensitive content. Cards with this property may have
     * missing or degraded properties and values. See this [official article](https://magic.wizards.com/en/articles/archive/news/depictions-racism-magic-2020-06-10) for more information.
     *
     * @return If the card marked by Wizards of the Coast for having sensitive content.
     */
    @get:JvmName("hasContentWarning")
    val hasContentWarning: Boolean = hasContentWarning ?: false

    /**
     * The mana value of the face for either half or part of the card. Formerly known as "converted mana cost".
     *
     * @return The mana value of the face for either half or part of the card. Formerly known as "converted mana cost".
     */
    val faceManaValue: Double = faceManaValue ?: 0.0

    /**
     * If the card has some kind of alternative variation to its printed counterpart.
     *
     * @return If the card has some kind of alternative variation to its printed counterpart.
     */
    val isAlternative: Boolean = isAlternative ?: false

    /**
     * If the card is oversized.
     *
     * @return If the card is oversized.
     */
    val isOversized: Boolean = isOversized ?: false

    /**
     * If the card is on the Magic: The Gathering [Reserved List](https://magic.wizards.com/en/articles/archive/official-reprint-policy-2010-03-10).
     *
     * @return If the card is on the Magic: The Gathering [Reserved List](https://magic.wizards.com/en/articles/archive/official-reprint-policy-2010-03-10).
     */
    val isReserved: Boolean = isReserved ?: false

    /**
     * If this card is found in a booster pack.
     *
     * @return If this card is found in a booster pack.
     */
    val isStarter: Boolean = isStarter ?: false

    /**
     * If the card has a story spotlight.
     *
     * @return If the card has a story spotlight.
     */
    val isStorySpotlight: Boolean = isStorySpotlight ?: false

    /**
     * If the card does not have a text box.
     *
     * @return If the card does not have a text box.
     */
    val isTextless: Boolean = isTextless ?: false

    /**
     * If this card is "timeshifted", a feature from Time Spiral block.
     *
     * @return If this card is "timeshifted", a feature from Time Spiral block.
     */
    val isTimeshifted: Boolean = isTimeshifted ?: false
}
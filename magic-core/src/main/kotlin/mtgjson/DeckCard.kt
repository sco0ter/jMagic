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

class DeckCard @ConstructorProperties(
    "artist",
    "asciiName",
    "availability",
    "borderColor",
    "colorIdentity",
    "colorIndicator",
    "colors",
    "count",
    "duelDeck",
    "edhrecRank",
    "faceName",
    "faceManaValue",
    "flavorName",
    "flavorText",
    "foreignData",
    "frameEffects",
    "frameVersion",
    "hand",
    "hasContentWarning",
    "hasFoil",
    "hasAlternativeDeckLimit",
    "hasNonFoil",
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
    /**
     * The count of how many of this card exists in a relevant deck.
     *
     * @return The count of how many of this card exists in a relevant deck.
     */
    val count: Int,
    /**
     * The indicator for which duel deck the card is in.
     *
     * @return The indicator for which duel deck the card is in.
     */
    val duelDeck: String,
    edhrecRank: Int?,
    faceName: String?,
    faceManaValue: Double,
    finishes: Set<Finish>,
    flavorName: String?,
    flavorText: String?,
    foreignData: Set<ForeignData>,
    frameEffects: Set<FrameEffect>,
    frameVersion: FrameVersion,
    hand: String?,
    hasContentWarning: Boolean,
    hasAlternativeDeckLimit: Boolean,
    identifiers: Identifiers,
    isAlternative: Boolean,
    isFullArt: Boolean,
    isOnlineOnly: Boolean,
    isOversized: Boolean,
    isPromo: Boolean,
    isReprint: Boolean,
    isReserved: Boolean,
    isStarter: Boolean,
    isStorySpotlight: Boolean,
    isTextless: Boolean,
    isTimeshifted: Boolean,
    keywords: List<String>,
    layout: Layout,  // TODO leadershipSkills
    legalities: Legalities?,
    life: String?,
    loyalty: String?,
    manaCost: String?,
    manaValue: Double,
    name: String,
    number: String,
    originalReleaseDate: LocalDate?,
    originalText: String?,
    originalType: String,
    otherFaceIds: List<String>,
    power: String?,
    printings: List<String>,
    promoTypes: List<String>,  // TODO purchaseUrls
    rarity: Rarity?,
    rulings: List<Ruling>,
    setCode: String,
    side: String?,
    subtypes: List<String>?,
    supertypes: List<String>?,
    text: String?,
    toughness: String?,
    type: String,
    types: List<String>,
    uuid: String?,
    variations: List<String>?,
    watermark: String?
) :
    SetCard(
        artist, asciiName, availabilities,
        borderColor, colorIdentity, colorIndicator, colors, edhrecRank,
        faceName, faceManaValue, finishes, flavorName, flavorText, foreignData, frameEffects, frameVersion,
        hand, hasContentWarning, hasAlternativeDeckLimit, identifiers, isAlternative, isFullArt, isOnlineOnly,
        isOversized, isPromo, isReprint, isReserved, isStarter, isStorySpotlight, isTextless, isTimeshifted,
        keywords, layout, legalities, life, loyalty, manaCost, manaValue, name, number, originalReleaseDate,
        originalText, originalType, otherFaceIds, power, printings, promoTypes, rarity, rulings, setCode, side,
        subtypes, supertypes, text, toughness, type, types, uuid, variations, watermark
    )
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
import kotlin.collections.Set

class TokenCard @ConstructorProperties(
    "artist",
    "asciiName",
    "availability",
    "borderColor",
    "colorIdentity",
    "colorIndicator",
    "colors",
    "edhrecRank",
    "faceName",
    "finishes",
    "flavorText",
    "frameEffects",
    "frameVersion",
    "identifiers",
    "isFullArt",
    "isOnlineOnly",
    "isPromo",
    "isReprint",
    "keywords",
    "layout",
    "loyalty",
    "name",
    "number",
    "power",
    "promoTypes",
    "reverseRelated",
    "setCode",
    "side",
    "subtypes",
    "supertypes",
    "text",
    "toughness",
    "type",
    "types",
    "uuid",
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
    finishes: Set<Finish>,
    flavorText: String?,
    frameEffects: Set<FrameEffect>?,
    frameVersion: FrameVersion,
    identifiers: Identifiers,
    isFullArt: Boolean,
    isOnlineOnly: Boolean,
    isPromo: Boolean,
    isReprint: Boolean,
    keywords: List<String>?,
    layout: Layout,
    loyalty: String?,
    name: String,
    number: String,
    power: String?,
    promoTypes: List<String>?,
    /**
     * The names of the cards that produce this card.
     *
     * @return The names of the cards that produce this card.
     */
    val reverseRelated: Set<String>,
    setCode: String,
    side: String?,
    subtypes: List<String>?,
    supertypes: List<String>?,
    text: String?,
    toughness: String?,
    type: String?,
    types: List<String>?,
    uuid: String?,
    watermark: String?
) :
    AbstractCard(
        artist, asciiName, availabilities, borderColor, colorIdentity, colorIndicator, colors, edhrecRank,
        faceName, finishes, flavorText, frameEffects, frameVersion, identifiers, isFullArt, isOnlineOnly,
        isPromo, isReprint, keywords, layout, loyalty, name, number, power, promoTypes, setCode, side, subtypes,
        supertypes, text, toughness, type!!, types, uuid, watermark
    )
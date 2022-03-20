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

import kotlin.collections.Set

abstract class AbstractCard internal constructor(

    /**
     * The name of the artist that illustrated the card art.
     *
     * @return The name of the artist that illustrated the card art.
     */
    val artist: String?,

    /**
     * The ASCII (Basic/128) code formatted card name with no special unicode characters.
     *
     * @return The ASCII (Basic/128) code formatted card name with no special unicode characters.
     */
    val asciiName: String?,

    availabilities: Set<Availability>,

    /**
     * The color of the card border.
     *
     * @return The color of the card border.
     */
    val borderColor: BorderColor,

    colorIdentity: Set<Color>?,

    colorIndicator: Set<Color>?,

    colors: Set<Color>,

    /**
     * The card rank on [EDHRec](https://www.edhrec.com/).
     *
     * @return The card rank on [EDHRec](https://www.edhrec.com/).
     */
    val edhrecRank: Int?,

    /**
     * The name on the face of the card.
     *
     * @return The name on the face of the card.
     */
    val faceName: String?,

    finishes: Set<Finish>,

    /**
     * The italicized text found below the rules text that has no game function.
     *
     * @return The italicized text found below the rules text that has no game function.
     */
    val flavorText: String?,

    /**
     * The visual frame effects.
     *
     * @return The visual frame effects.
     */
    frameEffects: Set<FrameEffect>?,

    /**
     * The version of the card frame style.
     *
     * @return The version of the card frame style.
     */
    val frameVersion: FrameVersion,

    /**
     * A list of identifiers associated to a card. See the Identifiers data model.
     *
     * @return A list of identifiers associated to a card. See the Identifiers data model.
     */
    val identifiers: Identifiers,

    /**
     * If the card has full artwork.
     *
     * @return If the card has full artwork.
     */
    isFullArt: Boolean?,

    /**
     * If the card is only available in [Magic: The Gathering Online](https://magic.wizards.com/en/mtgo).
     *
     * @return If the card is only available in [Magic: The Gathering Online](https://magic.wizards.com/en/mtgo).
     */
    isOnlineOnly: Boolean?,

    /**
     * If the card is promotional.
     *
     * @return If the card is promotional.
     */
    isPromo: Boolean?,

    /**
     * If the card has been reprinted.
     *
     * @return If the card has been reprinted.
     */
    isReprint: Boolean?,

    keywords: List<String>?,

    /**
     * The type of card layout. For a token card, this will be "token".
     *
     * @return The type of card layout. For a token card, this will be "token".
     */
    val layout: Layout,

    /**
     * The loyalty value of the card. Used on Planeswalker cards.
     *
     * @return The loyalty value of the card. Used on Planeswalker cards.
     */
    val loyalty: String?,

    /**
     * The name of the card. Cards with multiple faces, like "Split" and "Meld" cards are given a delimiter.
     *
     * @return The name of the card.
     */
    val name: String,

    /**
     * The number of the card. Can be prefixed or suffixed with a * or other characters for promo sets.
     *
     * @return The number of the card.
     */
    val number: String,

    /**
     * The power of the card.
     *
     * @return The power of the card.
     */
    val power: String?,

    promoTypes: List<String>?,

    /**
     * The set code of the card.
     *
     * @return The set code of the card.
     */
    val setCode: String,

    /**
     * The identifier of the card side. Used on cards with multiple faces.
     *
     * @return The identifier of the card side. Used on cards with multiple faces.
     */
    val side: String?,

    subtypes: List<String>?,

    supertypes: List<String>?,

    /**
     * The rules text of the card.
     *
     * @return The rules text of the card.
     */
    val text: String?,

    /**
     * The toughness of the card.
     *
     * @return The toughness of the card.
     */
    val toughness: String?,

    /**
     * Type of the card as visible, including any supertypes and subtypes.
     *
     * @return Type of the card as visible, including any supertypes and subtypes.
     */
    val type: String,

    /**
     * A list of all card types of the card, including Un‑sets and gameplay variants.
     *
     * @return A list of all card types of the card, including Un‑sets and gameplay variants.
     */
    types: List<String>?,

    /**
     * The universal unique identifier (v5) generated by MTGJSON. Each entry is unique.
     *
     * @return The universal unique identifier (v5) generated by MTGJSON. Each entry is unique.
     */
    val uuid: String?,

    /**
     * The name of the watermark on the card.
     *
     * @return The name of the watermark on the card.
     */
    val watermark: String?
) {

    /**
     * The card's available printing types.
     *
     * @return The card's available printing types.
     */
    val availabilities: Set<Availability> = java.util.Set.copyOf(availabilities)

    /**
     * A list of all the colors found in manaCost, colorIndicator, and text.
     *
     * @return A list of all the colors found in manaCost, colorIndicator, and text.
     */
    val colorIdentity: Set<Color> = if (colorIdentity != null) java.util.Set.copyOf(colorIdentity) else emptySet()

    /**
     * A list of all the colors in the color indicator (The symbol prefixed to a card's types).
     *
     * @return A list of all the colors in the color indicator (The symbol prefixed to a card's types).
     */
    val colorIndicator: Set<Color> = if (colorIndicator != null) java.util.Set.copyOf(colorIndicator) else emptySet()

    /**
     * A list of all the colors in manaCost and colorIndicator. Some cards may not have a value, such as cards with
     * "Devoid" in its text.
     *
     * @return A list of all the colors in manaCost and colorIndicator.
     */
    val colors: Set<Color> = java.util.Set.copyOf(colors)

    /**
     * The visual frame effects.
     *
     * @return The visual frame effects.
     */
    val frameEffects: Set<FrameEffect> = if (frameEffects != null) java.util.Set.copyOf(frameEffects) else emptySet()

    /**
     * The finishes of the card.
     *
     * @return The finishes of the card.
     */
    val finishes: Set<Finish> = java.util.Set.copyOf(finishes)

    /**
     * If the card has full artwork.
     *
     * @return If the card has full artwork.
     */
    val isFullArt: Boolean = isFullArt ?: false

    /**
     * If the card is only available in [Magic: The Gathering Online](https://magic.wizards.com/en/mtgo).
     *
     * @return If the card is only available in [Magic: The Gathering Online](https://magic.wizards.com/en/mtgo).
     */
    val isOnlineOnly: Boolean = isOnlineOnly ?: false

    /**
     * If the card is promotional.
     *
     * @return If the card is promotional.
     */
    val isPromo: Boolean = isPromo ?: false

    /**
     * If the card has been reprinted.
     *
     * @return If the card has been reprinted.
     */
    val isReprint: Boolean = isReprint ?: false

    /**
     * A list of keywords found on the card.
     *
     * @return A list of keywords found on the card.
     */
    val keywords: List<String> = if (keywords != null) java.util.List.copyOf(keywords) else emptyList()

    /**
     * A list of promotional types for a card.
     *
     * @return A list of promotional types for a card.
     */
    val promoTypes: List<String> = if (promoTypes != null) java.util.List.copyOf(promoTypes) else emptyList()

    /**
     * A list of card subtypes found after em-dash.
     *
     * @return A list of card subtypes found after em-dash.
     */
    val subtypes: List<String> = if (subtypes != null) java.util.List.copyOf(subtypes) else emptyList()

    /**
     * A list of card supertypes found before em-dash.
     *
     * @return A list of card supertypes found before em-dash.
     */
    val supertypes: List<String> = if (supertypes != null) java.util.List.copyOf(supertypes) else emptyList()

    /**
     * A list of all card types of the card, including Un‑sets and gameplay variants.
     *
     * @return A list of all card types of the card, including Un‑sets and gameplay variants.
     */
    val types: List<String> = if (types != null) java.util.List.copyOf(types) else emptyList()

    override fun toString(): String {
        return name
    }
}
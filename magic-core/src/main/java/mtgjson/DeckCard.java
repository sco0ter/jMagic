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

import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public final class DeckCard extends SetCard {

    private final int count;

    private final String duelDeck;

    @ConstructorProperties(
            {"artist", "asciiName", "availability", "borderColor", "colorIdentity", "colorIndicator", "colors",
                    "convertedManaCost", "count", "duelDeck", "edhrecRank", "faceConvertedManaCost", "faceName",
                    "flavorName", "flavorText", "foreignData", "frameEffects", "frameVersion", "hand",
                    "hasContentWarning", "hasFoil", "hasAlternativeDeckLimit", "hasNonFoil", "identifiers",
                    "isAlternative", "isFullArt", "isOnlineOnly", "isOversized", "isPromo", "isReprint", "isReserved",
                    "isStarter", "isStorySpotlight", "isTextless", "isTimeshifted", "keywords", "layout", "legalities",
                    "life", "loyalty", "manaCost", "name", "number", "originalReleaseDate", "originalText",
                    "originalType", "otherFaceIds", "power", "printings", "promoTypes", "rarity", "rulings", "setCode",
                    "side", "subtypes", "supertypes", "text", "toughness", "type", "types", "uuid", "variations",
                    "watermark"})
    public DeckCard(String artist,
                    String asciiName,
                    Set<Availability> availabilities,
                    BorderColor borderColor,
                    Set<Color> colorIdentity,
                    Set<Color> colorIndicator,
                    Set<Color> colors,
                    float convertedManaCost,
                    int count,
                    String duelDeck,
                    Integer edhrecRank,
                    float faceConvertedManaCost,
                    String faceName,
                    String flavorName,
                    String flavorText,
                    Set<ForeignData> foreignData,
                    Set<FrameEffect> frameEffects,
                    FrameVersion frameVersion,
                    String hand,
                    boolean hasContentWarning,
                    boolean hasFoil,
                    boolean hasAlternativeDeckLimit,
                    boolean hasNonFoil,
                    Identifiers identifiers,
                    boolean isAlternative,
                    boolean isFullArt,
                    boolean isOnlineOnly,
                    boolean isOversized,
                    boolean isPromo,
                    boolean isReprint,
                    boolean isReserved,
                    boolean isStarter,
                    boolean isStorySpotlight,
                    boolean isTextless,
                    boolean isTimeshifted,
                    List<String> keywords,
                    Layout layout,
                    // TODO leadershipSkills
                    Legalities legalities,
                    String life,
                    String loyalty,
                    String manaCost,
                    String name,
                    String number,
                    LocalDate originalReleaseDate,
                    String originalText,
                    String originalType,
                    List<String> otherFaceIds,
                    String power,
                    List<String> printings,
                    List<String> promoTypes,
                    // TODO purchaseUrls
                    Rarity rarity,
                    List<Ruling> rulings,
                    String setCode,
                    String side,
                    List<String> subtypes,
                    List<String> supertypes,
                    String text,
                    String toughness,
                    String type,
                    List<String> types,
                    String uuid,
                    List<String> variations,
                    String watermark) {
        super(artist, asciiName, availabilities, borderColor, colorIdentity, colorIndicator, colors, convertedManaCost,
                edhrecRank, faceConvertedManaCost, faceName, flavorName, flavorText, foreignData, frameEffects,
                frameVersion, hand, hasContentWarning, hasFoil, hasAlternativeDeckLimit, hasNonFoil, identifiers,
                isAlternative, isFullArt, isOversized, isOnlineOnly, isPromo, isReprint, isReserved, isStarter,
                isStorySpotlight, isTextless, isTimeshifted, keywords, layout, legalities, life, loyalty, manaCost,
                name, number, originalReleaseDate, originalText, originalType, otherFaceIds, power, printings,
                promoTypes, rarity, rulings, setCode, side, subtypes, supertypes, text, toughness, type, types, uuid,
                variations, watermark);
        this.count = count;
        this.duelDeck = duelDeck;
    }

    /**
     * The count of how many of this card exists in a relevant deck.
     *
     * @return The count of how many of this card exists in a relevant deck.
     */
    public final int getCount() {
        return count;
    }

    /**
     * The indicator for which duel deck the card is in.
     *
     * @return The indicator for which duel deck the card is in.
     */
    public final String getDuelDeck() {
        return duelDeck;
    }
}

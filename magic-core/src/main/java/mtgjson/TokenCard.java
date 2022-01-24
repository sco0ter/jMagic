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
import java.util.List;
import java.util.Set;

public final class TokenCard extends AbstractCard {

    private final Set<String> reverseRelated;

    @ConstructorProperties(
            {"artist", "asciiName", "availability", "borderColor", "colorIdentity", "colorIndicator", "colors",
                    "edhrecRank", "faceName", "finishes", "flavorText", "frameEffects", "frameVersion",
                    "identifiers", "isFullArt", "isOnlineOnly", "isPromo", "isReprint", "keywords",
                    "layout", "loyalty", "name", "number", "power", "promoTypes", "reverseRelated", "setCode", "side",
                    "subtypes",
                    "supertypes", "text", "toughness", "type", "types", "uuid", "watermark"})
    public TokenCard(String artist,
                     String asciiName,
                     Set<Availability> availabilities,
                     BorderColor borderColor,
                     Set<Color> colorIdentity,
                     Set<Color> colorIndicator,
                     Set<Color> colors,
                     Integer edhrecRank,
                     String faceName,
                     Set<Finish> finishes,
                     String flavorText,
                     Set<FrameEffect> frameEffects,
                     FrameVersion frameVersion,
                     Identifiers identifiers,
                     boolean isFullArt,
                     boolean isOnlineOnly,
                     boolean isPromo,
                     boolean isReprint,
                     List<String> keywords,
                     Layout layout,
                     String loyalty,
                     String name,
                     String number,
                     String power,
                     List<String> promoTypes,
                     Set<String> reverseRelated,
                     String setCode,
                     String side,
                     List<String> subtypes,
                     List<String> supertypes,
                     String text,
                     String toughness,
                     String type,
                     List<String> types,
                     String uuid,
                     String watermark) {
        super(artist, asciiName, availabilities, borderColor, colorIdentity, colorIndicator, colors, edhrecRank,
                faceName, finishes, flavorText, frameEffects, frameVersion, identifiers, isFullArt, isOnlineOnly,
                isPromo, isReprint, keywords, layout, loyalty, name, number, power, promoTypes, setCode, side, subtypes,
                supertypes, text, toughness, type, types, uuid, watermark);
        this.reverseRelated = reverseRelated;
    }

    /**
     * The names of the cards that produce this card.
     *
     * @return The names of the cards that produce this card.
     */
    public final Set<String> getReverseRelated() {
        return reverseRelated;
    }
}

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

public class SetCard extends AbstractCard {

    private final String flavorName;

    private final Set<ForeignData> foreignData;

    private final String hand;

    private final boolean hasContentWarning;

    private final boolean hasAlternativeDeckLimit;

    private final boolean isAlternative;

    private final boolean isOversized;

    private final boolean isReserved;

    private final boolean isStarter;

    private final boolean isStorySpotlight;

    private final boolean isTextless;

    private final boolean isTimeshifted;

    private final Legalities legalities;

    private final String life;

    private final String manaCost;

    private final double manaValue;

    private final LocalDate originalReleaseDate;

    private final String originalText;

    private final String originalType;

    private final String otherFaceIds;

    private final List<String> printings;

    private final Rarity rarity;

    private final List<Ruling> rulings;

    private final List<String> variations;

    @ConstructorProperties(
            {"artist", "asciiName", "availability", "borderColor", "colorIdentity", "colorIndicator", "colors",
                    "edhrecRank", "faceName", "flavorName", "flavorText", "foreignData", "frameEffects", "frameVersion",
                    "hand", "hasContentWarning", "hasFoil", "hasAlternativeDeckLimit", "hasNonFoil", "identifiers",
                    "isAlternative", "isFullArt", "isOnlineOnly", "isOversized", "isPromo", "isReprint", "isReserved",
                    "isStarter", "isStorySpotlight", "isTextless", "isTimeshifted", "keywords", "layout", "legalities",
                    "life", "loyalty", "manaCost", "manaValue", "name", "number", "originalReleaseDate", "originalText",
                    "originalType", "otherFaceIds", "power", "printings", "promoTypes", "rarity", "rulings", "setCode",
                    "side", "subtypes", "supertypes", "text", "toughness", "type", "types", "uuid", "variations",
                    "watermark"})
    public SetCard(String artist,
                   String asciiName,
                   Set<Availability> availabilities,
                   BorderColor borderColor,
                   Set<Color> colorIdentity,
                   Set<Color> colorIndicator,
                   Set<Color> colors,
                   Integer edhrecRank,
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
                   double manaValue,
                   String name,
                   String number,
                   LocalDate originalReleaseDate,
                   String originalText,
                   String originalType,
                   String otherFaceIds,
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
        super(artist, asciiName, availabilities, borderColor, colorIdentity, colorIndicator, colors, edhrecRank,
                faceName, flavorText, frameEffects,
                frameVersion, hasFoil, hasNonFoil, identifiers, isFullArt, isOnlineOnly, isPromo, isReprint, keywords,
                layout, loyalty, name, number, power, promoTypes, setCode, side, subtypes, supertypes, text, toughness,
                type, types, uuid, watermark);
        this.flavorName = flavorName;
        this.foreignData = foreignData;
        this.hand = hand;
        this.hasContentWarning = hasContentWarning;
        this.hasAlternativeDeckLimit = hasAlternativeDeckLimit;
        this.isAlternative = isAlternative;
        this.isOversized = isOversized;
        this.isReserved = isReserved;
        this.isStarter = isStarter;
        this.isStorySpotlight = isStorySpotlight;
        this.isTextless = isTextless;
        this.isTimeshifted = isTimeshifted;
        this.legalities = legalities;
        this.life = life;
        this.manaCost = manaCost;
        this.manaValue = manaValue;
        this.originalReleaseDate = originalReleaseDate;
        this.originalText = originalText;
        this.originalType = originalType;
        this.otherFaceIds = otherFaceIds;
        this.printings = printings;
        this.rarity = rarity;
        this.rulings = rulings;
        this.variations = variations;
    }

    /**
     * The promotional card name printed above the true card name on special cards that has no game function. See <a
     * href="https://scryfall.com/card/plg20/2/hangarback-walker">this card</a> for an example.
     *
     * @return The promotional card name printed above the true card name on special cards that has no game function.
     */
    public final String getFlavorName() {
        return flavorName;
    }

    /**
     * A list of data properties in other languages.
     *
     * @return A list of data properties in other languages.
     */
    public final Set<ForeignData> getForeignData() {
        return foreignData;
    }

    /**
     * The starting maximum hand size total modifier. A + or - character precedes an integer.
     *
     * @return The starting maximum hand size total modifier.
     */
    public final String getHand() {
        return hand;
    }

    /**
     * If the card marked by Wizards of the Coast for having sensitive content. Cards with this property may have
     * missing or degraded properties and values. See this <a href="https://magic.wizards.com/en/articles/archive/news/depictions-racism-magic-2020-06-10">official
     * article</a> for more information.
     *
     * @return If the card marked by Wizards of the Coast for having sensitive content.
     */
    public final boolean hasContentWarning() {
        return hasContentWarning;
    }

    /**
     * If the card allows a value other than 4 copies in a deck.
     *
     * @return If the card allows a value other than 4 copies in a deck.
     */
    public final boolean hasAlternativeDeckLimit() {
        return hasAlternativeDeckLimit;
    }

    /**
     * If the card has some kind of alternative variation to its printed counterpart.
     *
     * @return If the card has some kind of alternative variation to its printed counterpart.
     */
    public final boolean isAlternative() {
        return isAlternative;
    }

    /**
     * If the card is oversized.
     *
     * @return If the card is oversized.
     */
    public final boolean isOversized() {
        return isOversized;
    }

    /**
     * If the card is on the Magic: The Gathering <a href="https://magic.wizards.com/en/articles/archive/official-reprint-policy-2010-03-10">Reserved
     * List</a>.
     *
     * @return If the card is on the Magic: The Gathering <a href="https://magic.wizards.com/en/articles/archive/official-reprint-policy-2010-03-10">Reserved
     * List</a>.
     */
    public final boolean isReserved() {
        return isReserved;
    }

    /**
     * If this card is found in a booster pack.
     *
     * @return If this card is found in a booster pack.
     */
    public final boolean isStarter() {
        return isStarter;
    }

    /**
     * If the card has a story spotlight.
     *
     * @return If the card has a story spotlight.
     */
    public final boolean isStorySpotlight() {
        return isStorySpotlight;
    }

    /**
     * If the card does not have a text box.
     *
     * @return If the card does not have a text box.
     */
    public final boolean isTextless() {
        return isTextless;
    }

    /**
     * If this card is "timeshifted", a feature from Time Spiral block.
     *
     * @return If this card is "timeshifted", a feature from Time Spiral block.
     */
    public final boolean isTimeshifted() {
        return isTimeshifted;
    }

    /**
     * A list of play formats the card the card is legal in.
     *
     * @return A list of play formats the card the card is legal in.
     */
    public final Legalities getLegalities() {
        return legalities;
    }

    /**
     * The starting life total modifier. A plus or minus character precedes an integer. Used only on cards with
     * "Vanguard" in its types.
     *
     * @return The starting life total modifier.
     */
    public final String getLife() {
        return life;
    }

    /**
     * The mana cost of the card.
     *
     * @return The mana cost of the card.
     */
    public final String getManaCost() {
        return manaCost;
    }

    /**
     * The mana cost of the card.
     *
     * @return The mana cost of the card.
     */
    public final double getManaValue() {
        return manaValue;
    }

    /**
     * The original release date for a promotional card printed outside of a cycle window, such as Secret Lair Drop
     * promotions.
     *
     * @return The original release date.
     */
    public final LocalDate getOriginalReleaseDate() {
        return originalReleaseDate;
    }

    /**
     * The text on the card as originally printed.
     *
     * @return The text on the card as originally printed.
     */
    public final String getOriginalText() {
        return originalText;
    }

    /**
     * The type of the card as originally printed. Includes any supertypes and subtypes.
     *
     * @return The type of the card as originally printed. Includes any supertypes and subtypes.
     */
    public final String getOriginalType() {
        return originalType;
    }

    /**
     * A list of UUID's of this card with counterparts, such as transformed or melded faces.
     *
     * @return A list of UUID's of this card with counterparts, such as transformed or melded faces.
     */
    public final String getOtherFaceIds() {
        return otherFaceIds;
    }

    /**
     * A list of set codes the card was printed in, formatted in uppercase.
     *
     * @return A list of set codes the card was printed in, formatted in uppercase.
     */
    public final List<String> getPrintings() {
        return printings;
    }

    /**
     * The card printing rarity.
     *
     * @return The card printing rarity.
     */
    public final Rarity getRarity() {
        return rarity;
    }

    /**
     * The official rulings of the card. See the Rulings data model.
     *
     * @return The official rulings of the card. See the Rulings data model.
     */
    public final List<Ruling> getRulings() {
        return rulings;
    }

    /**
     * A list of UUID's of this card with alternate printings in the same set. Excludes Un‑sets.
     *
     * @return A list of UUID's of this card with alternate printings in the same set. Excludes Un‑sets.
     */
    public final List<String> getVariations() {
        return variations;
    }
}

package mtgjson;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Set;

public final class CardToken extends AbstractCard {

    private final Set<String> reverseRelated;

    @ConstructorProperties(
            {"artist", "asciiName", "availability", "borderColor", "colorIdentity", "colorIndicator", "colors",
                    "edhrecRank", "faceName", "flavorText", "frameEffects", "frameVersion", "hasFoil", "hasNonFoil",
                    "identifiers", "isFullArt", "isOnlineOnly", "isPromo", "isReprint", "keywords",
                    "layout", "loyalty", "name", "number", "power", "promoTypes", "reverseRelated", "setCode", "side",
                    "subtypes",
                    "supertypes", "text", "toughness", "type", "types", "uuid", "watermark"})
    public CardToken(String artist,
                     String asciiName,
                     Set<Availability> availabilities,
                     BorderColor borderColor,
                     Set<Color> colorIdentity,
                     Set<Color> colorIndicator,
                     Set<Color> colors,
                     Integer edhrecRank,
                     String faceName,
                     String flavorText,
                     Set<FrameEffect> frameEffects,
                     FrameVersion frameVersion,
                     boolean hasFoil,
                     boolean hasNonFoil,
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
                faceName, flavorText, frameEffects,
                frameVersion, hasFoil, hasNonFoil, identifiers, isFullArt, isOnlineOnly, isPromo, isReprint, keywords,
                layout, loyalty, name, number, power, promoTypes, setCode, side, subtypes, supertypes, text, toughness,
                type, types, uuid, watermark);
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

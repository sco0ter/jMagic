package mtgjson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.ConstructorProperties;
import java.util.Set;

public final class CardToken extends AbstractCard {

    @JsonProperty(required = true)
    private Set<String> reverseRelated;

    @ConstructorProperties({"artist", "asciiName", "availability", "borderColor", "colorIdentity", "colors",
            "convertedManaCost", "frameEffects", "frameVersion"})
    public CardToken(String artist, String asciiName, Set<Availability> availabilities, BorderColor borderColor, Set<Color> colorIdentity, Set<Color> colors, float convertedManaCost, Set<FrameEffect> frameEffects, FrameVersion frameVersion) {
        super(artist, asciiName, availabilities, borderColor, colorIdentity, colors, convertedManaCost, frameEffects, frameVersion);
    }
}

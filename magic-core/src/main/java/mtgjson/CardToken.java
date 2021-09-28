package mtgjson;

import java.beans.ConstructorProperties;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class CardToken extends AbstractCard {

    @JsonProperty(required = true)
    private Set<String> reverseRelated;

    @ConstructorProperties({"artist", "asciiName", "availability", "borderColor"})
    public CardToken(String artist, String asciiName, Set<Availability> availabilities, BorderColor borderColor) {
        super(artist, asciiName, availabilities, borderColor, null);
    }
}

package mtgjson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Set;

public class Card extends AbstractCard {

    @JsonProperty(required = true)
    private Set<ForeignData> foreignData;

    @JsonProperty(required = true)
    private Set<String> otherFaceIds;

    //    @JsonProperty(required = true)
//    private Set<String> purchaseUrls;

    @JsonProperty(required = true)
    private Rarity rarity;

    @JsonProperty(required = true)
    private List<Ruling> rulings;

    @JsonProperty(required = true)
    private List<String> variations;

    @ConstructorProperties({"artist", "asciiName", "availability", "borderColor", "frameVersion"})
    public Card(String artist, String asciiName, Set<Availability> availabilities, BorderColor borderColor, FrameVersion frameVersion) {
        super(artist, asciiName, availabilities, borderColor, frameVersion);
    }
}

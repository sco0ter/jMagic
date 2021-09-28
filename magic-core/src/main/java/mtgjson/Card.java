package mtgjson;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

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
}

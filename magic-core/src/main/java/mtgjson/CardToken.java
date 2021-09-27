package mtgjson;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class CardToken extends AbstractCard {

    @JsonProperty(required = true)
    private Set<String> reverseRelated;
}

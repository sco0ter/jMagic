package mtgjson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

/**
 * The Foreign Data data model describes a list of properties for various card data models in alternate languages.
 */
public final class ForeignData {

    @JsonProperty
    private String faceName;

    @JsonProperty
    private String flavorText;

    @JsonProperty(required = true)
    private String language;

    @JsonProperty
    private Integer multiverseId;

    @JsonProperty(required = true)
    private String name;

    @JsonProperty
    private String text;

    @JsonProperty
    private String type;

    /**
     * Gets the name on the face of the card.
     *
     * @return The name on the face of the card.
     */
    public Optional<String> getFaceName() {
        return Optional.ofNullable(faceName);
    }

    /**
     * Gets the flavor text of the card.
     *
     * @return The flavor text of the card.
     */
    public Optional<String> getFlavorText() {
        return Optional.ofNullable(flavorText);
    }

    /**
     * Gets the foreign language of card.
     *
     * @return The foreign language of card.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets the multiverse identifier of the card.
     *
     * @return The multiverse identifier of the card.
     */
    Optional<Integer> getMultiverseId() {
        return Optional.ofNullable(multiverseId);
    }

    /**
     * Gets the name of the card.
     *
     * @return The name of the card.
     */
    String getName() {
        return name;
    }

    /**
     * Gets the text ruling of the card.
     *
     * @return The text ruling of the card.
     */
    Optional<String> getText() {
        return Optional.ofNullable(text);
    }

    /**
     * Gets the type of the card. Includes any supertypes and subtypes.
     *
     * @return The type of the card. Includes any supertypes and subtypes.
     */
    Optional<String> getType() {
        return Optional.ofNullable(type);
    }

    @Override
    public final String toString() {
        return name + " (" + language + ')';
    }
}

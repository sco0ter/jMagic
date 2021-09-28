package mtgjson;

import java.beans.ConstructorProperties;
import java.util.Objects;
import java.util.Optional;

/**
 * The Foreign Data data model describes a list of properties for various card data models in alternate languages.
 *
 * <p>This class is immutable.</p>
 */
public final class ForeignData {

    private final String faceName;

    private final String flavorText;

    private final String language;

    private final Integer multiverseId;

    private final String name;

    private final String text;

    private final String type;

    @ConstructorProperties({"faceName", "flavorText", "language", "multiverseId", "name", "text", "type"})
    public ForeignData(String faceName, String flavorText, String language, Integer multiverseId, String name,
                       String text, String type) {
        this.faceName = faceName;
        this.flavorText = flavorText;
        this.language = Objects.requireNonNull(language);
        this.multiverseId = multiverseId;
        this.name = Objects.requireNonNull(name);
        this.text = text;
        this.type = type;
    }

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
    public Optional<Integer> getMultiverseId() {
        return Optional.ofNullable(multiverseId);
    }

    /**
     * Gets the name of the card.
     *
     * @return The name of the card.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the text ruling of the card.
     *
     * @return The text ruling of the card.
     */
    public Optional<String> getText() {
        return Optional.ofNullable(text);
    }

    /**
     * Gets the type of the card. Includes any supertypes and subtypes.
     *
     * @return The type of the card. Includes any supertypes and subtypes.
     */
    public Optional<String> getType() {
        return Optional.ofNullable(type);
    }

    @Override
    public final String toString() {
        return name + " (" + language + ')';
    }
}
package mtgjson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public abstract class AbstractCard {

    private final String artist;

    private final String asciiName;

    private final Set<Availability> availability;

    private final BorderColor borderColor;

    @JsonProperty(required = true)
    private Set<Color> colorIdentity;

    @JsonProperty(required = true)
    private Set<Color> colors;

    @JsonProperty(required = true)
    private float convertedManaCost;

    private final Set<FrameEffect> frameEffects;

    private FrameVersion frameVersion;

    @JsonProperty(required = true)
    private boolean hasFoil;

    @JsonProperty(required = true)
    private boolean hasNonFoil;

    @JsonProperty(required = true)
    private Identifiers identifiers;

    @JsonProperty(required = true)
    private Layout layout;

    @JsonProperty(required = true)
    private Legalities legalities;

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String number;

    @JsonProperty(required = true)
    private String setCode;

    @JsonProperty(required = true)
    private List<String> subtypes;

    @JsonProperty(required = true)
    private List<String> supertypes;

    @JsonProperty(required = true)
    private String type;

    @JsonProperty(required = true)
    private List<String> types;

    @JsonProperty(required = true)
    private String uuid;

    AbstractCard(String artist, String asciiName, Set<Availability> availabilities, BorderColor borderColor, Set<FrameEffect> frameEffects, FrameVersion frameVersion) {
        this.artist = artist;
        this.asciiName = asciiName;
        this.availability = availabilities;
        this.borderColor = borderColor;
        this.frameEffects = frameEffects;
        this.frameVersion = frameVersion;
    }

    @Override
    public String toString() {
        return name;
    }

    public BorderColor getBorderColor() {
        return borderColor;
    }

    public Set<Availability> getAvailabilities() {
        return availability;
    }

    public Set<FrameEffect> getFrameEffects() {
        return frameEffects;
    }
}

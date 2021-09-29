package mtgjson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public abstract class AbstractCard {

    private final String artist;

    private final String asciiName;

    private final Set<Availability> availability;

    private final BorderColor borderColor;

    private final Set<Color> colorIdentity;

    private final Set<Color> colors;

    private final float convertedManaCost;

    private final Set<FrameEffect> frameEffects;

    private final FrameVersion frameVersion;

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

    AbstractCard(String artist, String asciiName, Set<Availability> availabilities, BorderColor borderColor, Set<Color> colorIdentity, Set<Color> colors, float convertedManaCost, Set<FrameEffect> frameEffects, FrameVersion frameVersion) {
        this.artist = artist;
        this.asciiName = asciiName;
        this.availability = availabilities;
        this.borderColor = borderColor;
        this.colorIdentity = Set.copyOf(colorIdentity);
        this.colors = Set.copyOf(colors);
        this.convertedManaCost = convertedManaCost;
        this.frameEffects = frameEffects != null ? Set.copyOf(frameEffects) : Collections.emptySet();
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

    public Set<Color> getColorIdentity() {
        return colorIdentity;
    }

    public Set<Color> getColors() {
        return colors;
    }
}

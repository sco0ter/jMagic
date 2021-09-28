package mtgjson;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractCard {
    
    @JsonProperty(required = true)
    private String artist;

    @JsonProperty(required = true)
    private String asciiName;

    @JsonProperty(required = true)
    private Set<Availability> availability;

    @JsonProperty(required = true)
    private BorderColor borderColor;

    @JsonProperty(required = true)
    private Set<Color> colorIdentity;

    @JsonProperty(required = true)
    private Set<Color> colors;

    @JsonProperty(required = true)
    private float convertedManaCost;

    @JsonProperty(required = true)
    private Set<FrameEffect> frameEffects;

    @JsonProperty(required = true)
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

    @Override
    public String toString() {
        return name;
    }
}

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Set {

    @JsonProperty(required = true)
    private Integer baseSetSize;

    @JsonProperty
    private String block;

    @JsonProperty
    private List<Card> cards;

    @JsonProperty(required = true)
    private String code;

    @JsonProperty
    private String codeV3;

    @JsonProperty
    private String isForeignOnly;

    @JsonProperty(required = true)
    private Boolean isFoilOnly;

    @JsonProperty
    private Boolean isNonFoilOnly;

    @JsonProperty(required = true)
    private Boolean isOnlineOnly;

    @JsonProperty
    private Boolean isPaperOnly;

    @JsonProperty
    private Boolean isPartialPreview;

    @JsonProperty(required = true)
    private String keyruneCode;

    @JsonProperty
    private Integer mcmId;

    @JsonProperty
    private Integer mcmIdExtras;

    @JsonProperty
    private String mcmName;

    @JsonProperty
    private String mtgoCode;

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private LocalDate releaseDate;

    @JsonProperty
    private String parentCode;

    @JsonProperty(required = true)
    private java.util.Set<CardToken> tokens;

    @JsonProperty(required = true)
    private Integer totalSetSize;

//    @JsonProperty(required = true)
//    private java.util.Set<Card> translations;

    @JsonProperty(required = true)
    private String type;

    @Override
    public final String toString() {
        return name + " (" + code + ')';
    }
}

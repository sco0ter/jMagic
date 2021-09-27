import com.fasterxml.jackson.annotation.JsonValue;

public enum FrameEffect {
    COLORSHIFTED("colorshifted"),
    COMPANION("companion"),
    COMPASSLANDDFC("compasslanddfc"),
    DEVOID("devoid"),
    DRAFT("draft"),
    ETCHED("etched"),
    EXTENDEDART("extendedart"),
    FULLART("fullart"),
    INVERTED("inverted"),
    LEGENDARY("legendary"),
    MIRACLE("miracle"),
    MOONELDRAZIDFC("mooneldrazidfc"),
    NYXBORN("nyxborn"),
    NYXTOUCHED("nyxtouched"),
    ORIGINPWDFC("originpwdfc"),
    SHOWCASE("showcase"),
    SNOW("snow"),
    SUNMOONDFC("sunmoondfc"),
    TOMBSTONE("tombstone"),
    WAXINGANDWANINGMOONDFC("waxingandwaningmoondfc");

    @JsonValue
    private final String value;

    FrameEffect(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

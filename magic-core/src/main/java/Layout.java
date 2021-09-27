import com.fasterxml.jackson.annotation.JsonValue;

public enum Layout {
    ADVENTURE("adventure"),
    AFTERMATH("aftermath"),
    ART_SERIES("art_series"),
    AUGMENT("augment"),
    CLASS("class"),
    EMBLEM("emblem"),
    FLIP("flip"),
    HOST("host"),
    LEVELER("leveler"),
    MELD("meld"),
    MODAL_DFC("modal_dfc"),
    NORMAL("normal"),
    PLANAR("planar"),
    SAGA("saga"),
    SCHEME("scheme"),
    SPLIT("split"),
    TOKEN("token"),
    TRANSFORM("transform"),
    VANGUARD("vanguard");

    @JsonValue
    private final String value;

    Layout(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

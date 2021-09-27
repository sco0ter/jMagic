import com.fasterxml.jackson.annotation.JsonValue;

public enum FrameVersion {

    _1993("1993"), _1997("1997"), _2003("2003"), _2015("2015"), FUTURE("future");

    @JsonValue
    private final String value;

    FrameVersion(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

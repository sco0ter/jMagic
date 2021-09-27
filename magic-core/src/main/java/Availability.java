import com.fasterxml.jackson.annotation.JsonValue;

public enum Availability {

    ARENEA("arena"),
    DREAMCAST("dreamcast"),
    MTGO("mtgo"),
    PAPER("paper"),
    SHANDALAR("shandalar");

    @JsonValue
    private final String value;

    Availability(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

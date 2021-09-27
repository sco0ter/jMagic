import com.fasterxml.jackson.annotation.JsonValue;

public enum BorderColor {
    BLACK("black"),
    BORDERLESS("borderless"),
    GOLD("gold"),
    SILVER("silver"),
    WHITE("white");

    @JsonValue
    private final String value;

    BorderColor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

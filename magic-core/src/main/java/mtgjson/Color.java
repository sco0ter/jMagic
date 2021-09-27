package mtgjson;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Color {
    WHITE("W"),
    BLUE("U"),
    BLACK("B"),
    RED("R"),
    GREEN("G");

    @JsonValue
    private final String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

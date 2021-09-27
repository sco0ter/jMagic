import com.fasterxml.jackson.annotation.JsonValue;

public enum Rarity {

    COMMON("common"),
    UNCOMMON("uncommon"),
    RARE("rare"),
    MYTHIC("mythic"),
    BONUS("bonus"),
    SPECIAL("special");

    @JsonValue
    private final String value;

    Rarity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

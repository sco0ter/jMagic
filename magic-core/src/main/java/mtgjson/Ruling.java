package mtgjson;

import java.beans.ConstructorProperties;
import java.time.LocalDate;

/**
 * The Rulings data model describes a list of rulings for a specific card.
 */
public final class Ruling {

    private final LocalDate date;

    private final String text;

    @ConstructorProperties({"date", "text"})
    public Ruling(LocalDate date, String text) {
        this.date = date;
        this.text = text;
    }

    /**
     * Gets the release date for the rule.
     *
     * @return The release date for the rule.
     */
    public final LocalDate getDate() {
        return date;
    }

    /**
     * Gets the text ruling of the card.
     *
     * @return The text ruling of the card.
     */
    public final String getText() {
        return text;
    }

    @Override
    public final String toString() {
        return text + " (" + date + ')';
    }
}

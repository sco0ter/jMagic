package mtgjson;

import java.beans.ConstructorProperties;

/**
 * The Translations data model describes the translated data per language as a key.
 *
 * <p>This class is immutable.</p>
 */
public final class Translations {

    private final String ancientGreek;

    private final String arabic;

    private final String chineseSimplified;

    private final String chineseTraditional;

    private final String french;

    private final String german;

    private final String hebrew;

    private final String italian;

    private final String japanese;

    private final String korean;

    private final String latin;

    private final String phyrexian;

    private final String portuguese;

    private final String russian;

    private final String sanskrit;

    private final String spanish;

    @ConstructorProperties(
            {"Ancient Greek", "Arabic", "Chinese Simplified", "Chinese Traditional", "French", "German", "Hebrew",
                    "Italian", "Japanese", "Korean", "Latin", "Phyrexian", "Portuguese (Brazil)", "Russian", "Sanskrit",
                    "Spanish"})
    public Translations(String ancientGreek, String arabic, String chineseSimplified, String chineseTraditional,
                        String french,
                        String german, String hebrew, String italian, String japanese, String korean, String latin,
                        String phyrexian, String portuguese, String russian, String sanskrit, String spanish) {
        this.ancientGreek = ancientGreek;
        this.arabic = arabic;
        this.chineseSimplified = chineseSimplified;
        this.chineseTraditional = chineseTraditional;
        this.french = french;
        this.german = german;
        this.hebrew = hebrew;
        this.italian = italian;
        this.japanese = japanese;
        this.korean = korean;
        this.latin = latin;
        this.phyrexian = phyrexian;
        this.portuguese = portuguese;
        this.russian = russian;
        this.sanskrit = sanskrit;
        this.spanish = spanish;
    }

    /**
     * Gets the set name translation in Ancient Greek.
     *
     * @return The set name translation in Ancient Greek.
     */
    public String getAncientGreek() {
        return ancientGreek;
    }

    /**
     * Gets the set name translation in Arabic.
     *
     * @return The set name translation in Arabic.
     */
    public String getArabic() {
        return arabic;
    }

    /**
     * Gets the set name translation in Chinese Simplified.
     *
     * @return The set name translation in Chinese Simplified.
     */
    public String getChineseSimplified() {
        return chineseSimplified;
    }

    /**
     * Gets the set name translation in Chinese Traditional.
     *
     * @return The set name translation in Chinese Traditional.
     */
    public String getChineseTraditional() {
        return chineseTraditional;
    }

    /**
     * Gets the set name translation in French.
     *
     * @return The set name translation in French.
     */
    public String getFrench() {
        return french;
    }

    /**
     * Gets the set name translation in German.
     *
     * @return The set name translation in German.
     */
    public String getGerman() {
        return german;
    }

    /**
     * Gets the set name translation in Hebrew.
     *
     * @return The set name translation in Hebrew.
     */
    public String getHebrew() {
        return hebrew;
    }

    /**
     * Gets the set name translation in Italian.
     *
     * @return The set name translation in Italian.
     */
    public String getItalian() {
        return italian;
    }

    /**
     * Gets the set name translation in Japanese.
     *
     * @return The set name translation in Japanese.
     */
    public String getJapanese() {
        return japanese;
    }

    /**
     * Gets the set name translation in Korean.
     *
     * @return The set name translation in Korean.
     */
    public String getKorean() {
        return korean;
    }

    /**
     * Gets the set name translation in Latin.
     *
     * @return The set name translation in Latin.
     */
    public String getLatin() {
        return latin;
    }

    /**
     * Gets the set name translation in Phyrexian.
     *
     * @return The set name translation in Phyrexian.
     */
    public String getPhyrexian() {
        return phyrexian;
    }

    /**
     * Gets the set name translation in Portuguese (Brazil).
     *
     * @return The set name translation in Portuguese (Brazil).
     */
    public String getPortuguese() {
        return portuguese;
    }

    /**
     * Gets the set name translation in Russian.
     *
     * @return The set name translation in Russian.
     */
    public String getRussian() {
        return russian;
    }

    /**
     * Gets the set name translation in Sanskrit.
     *
     * @return The set name translation in Sanskrit.
     */
    public String getSanskrit() {
        return sanskrit;
    }

    /**
     * Gets the set name translation in Spanish.
     *
     * @return The set name translation in Spanish.
     */
    public String getSpanish() {
        return spanish;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Translations{");
        if (ancientGreek != null) {
            sb.append("ancientGreek='").append(ancientGreek).append("', ");
        }
        if (arabic != null) {
            sb.append("arabic='").append(arabic).append("', ");
        }
        if (chineseSimplified != null) {
            sb.append("chineseSimplified='").append(chineseSimplified).append("', ");
        }
        if (chineseTraditional != null) {
            sb.append("chineseTraditional='").append(chineseTraditional).append("', ");
        }
        if (french != null) {
            sb.append("french='").append(french).append("', ");
        }
        if (german != null) {
            sb.append("german='").append(german).append("', ");
        }
        if (hebrew != null) {
            sb.append("hebrew='").append(hebrew).append("', ");
        }
        if (italian != null) {
            sb.append("italian='").append(italian).append("', ");
        }
        if (japanese != null) {
            sb.append("japanese='").append(japanese).append("', ");
        }
        if (korean != null) {
            sb.append("korean='").append(korean).append("', ");
        }
        if (latin != null) {
            sb.append("latin='").append(latin).append("', ");
        }
        if (phyrexian != null) {
            sb.append("phyrexian='").append(phyrexian).append("', ");
        }
        if (portuguese != null) {
            sb.append("portuguese='").append(portuguese).append("', ");
        }
        if (russian != null) {
            sb.append("russian='").append(russian).append("', ");
        }
        if (sanskrit != null) {
            sb.append("sanskrit='").append(sanskrit).append("', ");
        }
        if (spanish != null) {
            sb.append("spanish='").append(spanish).append("', ");
        }
        sb.setLength(sb.length() - 2);
        sb.append('}');
        return sb.toString();
    }
}

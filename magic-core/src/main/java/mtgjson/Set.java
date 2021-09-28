package mtgjson;

import com.fasterxml.jackson.annotation.JsonValue;
import org.jooq.Converter;
import org.jooq.impl.EnumConverter;

import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public final class Set {

    private final Integer baseSetSize;

    private final String block;

    private final List<Card> cards = new ArrayList<>();

    private final String code;

    private final String codeV3;

    private final Boolean isForeignOnly;

    private final Boolean isFoilOnly;

    private final Boolean isNonFoilOnly;

    private final Boolean isOnlineOnly;

    private final Boolean isPaperOnly;

    private final Boolean isPartialPreview;

    private final String keyruneCode;

    private final Integer mcmId;

    private final Integer mcmIdExtras;

    private final String mcmName;

    private final String mtgoCode;

    private final String name;

    private final LocalDate releaseDate;

    private final String parentCode;

    private final java.util.Set<CardToken> tokens = new HashSet<>();

    private final Integer totalSetSize;

    @JsonProperty(required = true)
    private Translations translations;

    private final Type type;

    // This annotation is used by Jackson for deserialization and by jOOQ for database mapping.
    @ConstructorProperties({"baseSetSize", "block", "code", "codeV3","cards", "isForeignOnly", "isFoilOnly", "isNonFoilOnly",
            "isOnlineOnly", "isPaperOnly", "isPartialPreview", "keyruneCode", "mcmId", "mcmIdExtras", "mcmName",
            "mtgoCode", "name", "releaseDate", "parentCode", "tokens", "totalSetSize", "type"
    })
    public Set(Integer baseSetSize,
               String block,
               String code,
               String codeV3,
               List<Card> cards,
               Boolean isForeignOnly,
               Boolean isFoilOnly,
               Boolean isNonFoilOnly,
               Boolean isOnlineOnly,
               Boolean isPaperOnly,
               Boolean isPartialPreview,
               String keyruneCode,
               Integer mcmId,
               Integer mcmIdExtras,
               String mcmName,
               String mtgoCode,
               String name,
               LocalDate releaseDate,
               String parentCode,
               List<CardToken> tokens,
               Integer totalSetSize,
               Type type) {
        this.baseSetSize = Objects.requireNonNull(baseSetSize);
        this.block = block;
        this.code = Objects.requireNonNull(code);
        this.codeV3 = codeV3;
        this.cards.addAll(cards);
        this.isForeignOnly = isForeignOnly;
        this.isFoilOnly = Objects.requireNonNull(isFoilOnly);
        this.isNonFoilOnly = isNonFoilOnly;
        this.isOnlineOnly = Objects.requireNonNull(isOnlineOnly);
        this.isPaperOnly = isPaperOnly;
        this.isPartialPreview = isPartialPreview;
        this.keyruneCode = Objects.requireNonNull(keyruneCode);
        this.mcmId = mcmId;
        this.mcmIdExtras = mcmIdExtras;
        this.mcmName = mcmName;
        this.mtgoCode = mtgoCode;
        this.name = Objects.requireNonNull(name);
        this.releaseDate = Objects.requireNonNull(releaseDate);
        this.parentCode = parentCode;
        this.tokens.addAll(tokens);
        this.totalSetSize = Objects.requireNonNull(totalSetSize);
        this.type = Objects.requireNonNull(type);
    }

    public Translations getTranslations() {
        return translations;
    }

    public enum Type {

        ARCHENEMY("archenemy"),
        BOX("box"),
        COMMANDER("commander"),
        CORE("core"),
        DRAFT_INNOVATION("draft_innovation"),
        DUEL_DECK("duel_deck"),
        EXPANSION("expansion"),
        FROM_THE_VAULT("from_the_vault"),
        FUNNY("funny"),
        MASTERPIECE("masterpiece"),
        MASTERS("masters"),
        MEMORABILIA("memorabilia"),
        PLANECHASE("planechase"),
        PREMIUM_DECK("premium_deck"),
        PROMO("promo"),
        SPELLBOOK("spellbook"),
        STARTER("starter"),
        TOKEN("token"),
        TREASURE_CHEST("treasure_chest"),
        VANGUARD("vanguard");

        @JsonValue
        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Override
    public final String toString() {
        return name + " (" + code + ')';
    }
}

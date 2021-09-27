import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public final class Identifier {

    @JsonProperty
    private String cardKingdomFoilId;

    @JsonProperty
    private String cardKingdomId;

    @JsonProperty
    private String mcmId;

    @JsonProperty
    private String mcmMetaId;

    @JsonProperty
    private String mtgArenaId;

    @JsonProperty
    private String mtgoFoilId;

    @JsonProperty
    private String mtgoId;

    @JsonProperty
    private String mtgjsonV4Id;

    @JsonProperty
    private String multiverseId;

    @JsonProperty
    private String scryfallId;

    @JsonProperty
    private String scryfallOracleId;

    @JsonProperty
    private String scryfallIllustrationId;

    @JsonProperty
    private String tcgplayerProductId;

    /**
     * Gets the <a href="https://www.cardkingdom.com">Card Kingdom</a> card foil identifier.
     *
     * @return The <a href="https://www.cardkingdom.com">Card Kingdom</a> card foil identifier.
     */
    public Optional<String> getCardKingdomFoilId() {
        return Optional.ofNullable(cardKingdomFoilId);
    }

    /**
     * Gets the <a href="https://www.cardkingdom.com">Card Kingdom</a> card identifier.
     *
     * @return The <a href="https://www.cardkingdom.com">Card Kingdom</a> card identifier.
     */
    public Optional<String> getCardKingdomId() {
        return Optional.ofNullable(cardKingdomId);
    }

    /**
     * Gets the <a href="https://www.cardmarket.com/en/Magic">Card Market</a> card identifier.
     *
     * @return The <a href="https://www.cardmarket.com/en/Magic">Card Market</a> card identifier.
     */
    public Optional<String> getMcmId() {
        return Optional.ofNullable(mcmId);
    }

    /**
     * Gets the <a href="https://www.cardmarket.com/en/Magic">Card Market</a> card meta identifier.
     *
     * @return The <a href="https://www.cardmarket.com/en/Magic">Card Market</a> card meta identifier.
     */
    public Optional<String> getMcmMetaId() {
        return Optional.ofNullable(mcmMetaId);
    }

    /**
     * The <a href="https://magic.wizards.com/en/mtgarena">Magic: The Gathering Arena</a> card identifier.
     *
     * @return The <a href="https://magic.wizards.com/en/mtgarena">Magic: The Gathering Arena</a> card identifier.
     */
    public Optional<String> getMtgArenaId() {
        return Optional.ofNullable(mtgArenaId);
    }

    /**
     * Gets the <a href="https://magic.wizards.com/en/mtgo">Magic: The Gathering Online</a> card foil identifier.
     *
     * @return The The <a href="https://magic.wizards.com/en/mtgo">Magic: The Gathering Online</a> card foil identifier.
     */
    public Optional<String> getMtgoFoilId() {
        return Optional.ofNullable(mtgoFoilId);
    }

    /**
     * Gets the <a href="https://magic.wizards.com/en/mtgo">Magic: The Gathering Online</a> card identifier.
     *
     * @return The <a href="https://magic.wizards.com/en/mtgo">Magic: The Gathering Online</a> card identifier.
     */
    public Optional<String> getMtgoId() {
        return Optional.ofNullable(mtgoId);
    }

    /**
     * Gets the universal unique identifier generated by MTGJSON. Each entry is unique. Entries are for MTGJSON v4 uuid generation.
     *
     * @return The universal unique identifier generated by MTGJSON. Each entry is unique. Entries are for MTGJSON v4 uuid generation.
     */
    public Optional<String> getMtgjsonV4Id() {
        return Optional.ofNullable(mtgjsonV4Id);
    }

    /**
     * Gets the <a href="https://company.wizards.com/">Wizards of the Coast</a> card identifier used in conjunction with <a href="https://gatherer.wizards.com/">Gatherer</a>.
     *
     * @return The <a href="https://company.wizards.com/">Wizards of the Coast</a> card identifier used in conjunction with <a href="https://gatherer.wizards.com/">Gatherer</a>.
     */
    public Optional<String> getMultiverseId() {
        return Optional.ofNullable(multiverseId);
    }

    /**
     * Gets the universal unique identifier generated by <a href="https://scryfall.com/">Scryfall</a>. Note that cards with multiple faces are not unique.
     *
     * @return The universal unique identifier generated by <a href="https://scryfall.com/">Scryfall</a>. Note that cards with multiple faces are not unique.
     */
    public Optional<String> getScryfallId() {
        return Optional.ofNullable(scryfallId);
    }

    /**
     * Gets the unique identifier generated by <a href="https://scryfall.com/">Scryfall</a> for this card's oracle identity. This value is consistent across reprinted card editions, and unique among different cards with the same name (tokens, Unstable variants, etc).
     *
     * @return The unique identifier generated by <a href="https://scryfall.com/">Scryfall</a> for this card's oracle identity.
     */
    public Optional<String> getScryfallOracleId() {
        return Optional.ofNullable(scryfallOracleId);
    }

    /**
     * Gets the unique identifier generated by <a href="https://scryfall.com/">Scryfall</a> for the card artwork that remains consistent across reprints. Newly spoiled cards may not have this field yet.
     *
     * @return The unique identifier generated by <a href="https://scryfall.com/">Scryfall</a> for the card artwork that remains consistent across reprints.
     */
    public Optional<String> getScryfallIllustrationId() {
        return Optional.ofNullable(scryfallIllustrationId);
    }

    /**
     * Gets the <a href="https://www.tcgplayer.com">TCGplayer</a> card identifier.
     *
     * @return The <a href="https://www.tcgplayer.com">TCGplayer</a> card identifier.
     */
    public Optional<String> getTcgplayerProductId() {
        return Optional.ofNullable(tcgplayerProductId);
    }
}

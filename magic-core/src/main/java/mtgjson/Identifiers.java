/*
 * MIT License
 *
 * Copyright (c) 2021 Christian Schudt
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package mtgjson;

import java.beans.ConstructorProperties;

/**
 * The Identifiers data model describes a list of identifiers associated to a card.
 *
 * <p>This class is immutable.</p>
 */
public final class Identifiers {

    private final String cardKingdomFoilId;

    private final String cardKingdomId;

    private final String mcmId;

    private final String mcmMetaId;

    private final String mtgArenaId;

    private final String mtgoFoilId;

    private final String mtgoId;

    private final String mtgjsonV4Id;

    private final String multiverseId;

    private final String scryfallId;

    private final String scryfallOracleId;

    private final String scryfallIllustrationId;

    private final String tcgplayerProductId;

    @ConstructorProperties(
            {"cardKingdomFoilId", "cardKingdomId", "mcmId", "mcmMetaId", "mtgArenaId", "mtgoFoilId", "mtgoId",
                    "mtgjsonV4Id", "multiverseId", "scryfallId", "scryfallOracleId", "scryfallIllustrationId",
                    "tcgplayerProductId"})
    public Identifiers(String cardKingdomFoilId, String cardKingdomId, String mcmId, String mcmMetaId,
                       String mtgArenaId, String mtgoFoilId, String mtgoId, String mtgjsonV4Id, String multiverseId,
                       String scryfallId, String scryfallOracleId, String scryfallIllustrationId,
                       String tcgplayerProductId) {
        this.cardKingdomFoilId = cardKingdomFoilId;
        this.cardKingdomId = cardKingdomId;
        this.mcmId = mcmId;
        this.mcmMetaId = mcmMetaId;
        this.mtgArenaId = mtgArenaId;
        this.mtgoFoilId = mtgoFoilId;
        this.mtgoId = mtgoId;
        this.mtgjsonV4Id = mtgjsonV4Id;
        this.multiverseId = multiverseId;
        this.scryfallId = scryfallId;
        this.scryfallOracleId = scryfallOracleId;
        this.scryfallIllustrationId = scryfallIllustrationId;
        this.tcgplayerProductId = tcgplayerProductId;
    }

    /**
     * Gets the <a href="https://www.cardkingdom.com">Card Kingdom</a> card foil identifier.
     *
     * @return The <a href="https://www.cardkingdom.com">Card Kingdom</a> card foil identifier.
     */
    public String getCardKingdomFoilId() {
        return cardKingdomFoilId;
    }

    /**
     * Gets the <a href="https://www.cardkingdom.com">Card Kingdom</a> card identifier.
     *
     * @return The <a href="https://www.cardkingdom.com">Card Kingdom</a> card identifier.
     */
    public String getCardKingdomId() {
        return cardKingdomId;
    }

    /**
     * Gets the <a href="https://www.cardmarket.com/en/Magic">Card Market</a> card identifier.
     *
     * @return The <a href="https://www.cardmarket.com/en/Magic">Card Market</a> card identifier.
     */
    public String getMcmId() {
        return mcmId;
    }

    /**
     * Gets the <a href="https://www.cardmarket.com/en/Magic">Card Market</a> card meta identifier.
     *
     * @return The <a href="https://www.cardmarket.com/en/Magic">Card Market</a> card meta identifier.
     */
    public String getMcmMetaId() {
        return mcmMetaId;
    }

    /**
     * The <a href="https://magic.wizards.com/en/mtgarena">Magic: The Gathering Arena</a> card identifier.
     *
     * @return The <a href="https://magic.wizards.com/en/mtgarena">Magic: The Gathering Arena</a> card identifier.
     */
    public String getMtgArenaId() {
        return mtgArenaId;
    }

    /**
     * Gets the <a href="https://magic.wizards.com/en/mtgo">Magic: The Gathering Online</a> card foil identifier.
     *
     * @return The The <a href="https://magic.wizards.com/en/mtgo">Magic: The Gathering Online</a> card foil identifier.
     */
    public String getMtgoFoilId() {
        return mtgoFoilId;
    }

    /**
     * Gets the <a href="https://magic.wizards.com/en/mtgo">Magic: The Gathering Online</a> card identifier.
     *
     * @return The <a href="https://magic.wizards.com/en/mtgo">Magic: The Gathering Online</a> card identifier.
     */
    public String getMtgoId() {
        return mtgoId;
    }

    /**
     * Gets the universal unique identifier generated by MTGJSON. Each entry is unique. Entries are for MTGJSON v4 uuid
     * generation.
     *
     * @return The universal unique identifier generated by MTGJSON. Each entry is unique. Entries are for MTGJSON v4
     * uuid generation.
     */
    public String getMtgjsonV4Id() {
        return mtgjsonV4Id;
    }

    /**
     * Gets the <a href="https://company.wizards.com/">Wizards of the Coast</a> card identifier used in conjunction
     * with
     * <a href="https://gatherer.wizards.com/">Gatherer</a>.
     *
     * @return The <a href="https://company.wizards.com/">Wizards of the Coast</a> card identifier used in conjunction
     * with <a href="https://gatherer.wizards.com/">Gatherer</a>.
     */
    public String getMultiverseId() {
        return multiverseId;
    }

    /**
     * Gets the universal unique identifier generated by <a href="https://scryfall.com/">Scryfall</a>. Note that cards
     * with multiple faces are not unique.
     *
     * @return The universal unique identifier generated by <a href="https://scryfall.com/">Scryfall</a>. Note that
     * cards with multiple faces are not unique.
     */
    public String getScryfallId() {
        return scryfallId;
    }

    /**
     * Gets the unique identifier generated by <a href="https://scryfall.com/">Scryfall</a> for this card's oracle
     * identity. This value is consistent across reprinted card editions, and unique among different cards with the same
     * name (tokens, Unstable variants, etc).
     *
     * @return The unique identifier generated by <a href="https://scryfall.com/">Scryfall</a> for this card's oracle
     * identity.
     */
    public String getScryfallOracleId() {
        return scryfallOracleId;
    }

    /**
     * Gets the unique identifier generated by <a href="https://scryfall.com/">Scryfall</a> for the card artwork that
     * remains consistent across reprints. Newly spoiled cards may not have this field yet.
     *
     * @return The unique identifier generated by <a href="https://scryfall.com/">Scryfall</a> for the card artwork that
     * remains consistent across reprints.
     */
    public String getScryfallIllustrationId() {
        return scryfallIllustrationId;
    }

    /**
     * Gets the <a href="https://www.tcgplayer.com">TCGplayer</a> card identifier.
     *
     * @return The <a href="https://www.tcgplayer.com">TCGplayer</a> card identifier.
     */
    public String getTcgplayerProductId() {
        return tcgplayerProductId;
    }
}

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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;

public final class Set {

    private final Integer baseSetSize;

    private final String block;

    private final List<SetCard> cards = new ArrayList<>();

    private final String code;

    private final String codeV3;

    private final boolean isFoilOnly;

    private final boolean isForeignOnly;

    private final boolean isNonFoilOnly;

    private final boolean isOnlineOnly;

    private final boolean isPaperOnly;

    private final boolean isPartialPreview;

    private final String keyruneCode;

    private final Integer mcmId;

    private final Integer mcmIdExtras;

    private final String mcmName;

    private final String mtgoCode;

    private final String name;

    private final String parentCode;

    private final LocalDate releaseDate;

    private final Integer tcgplayerGroupId;

    private final List<TokenCard> tokens = new ArrayList<>();

    private final Integer totalSetSize;

    private final Translations translations;

    private final Type type;

    // This annotation is used by Jackson for deserialization and by jOOQ for database mapping.
    @ConstructorProperties(
            {"baseSetSize", "block", "code", "codeV3", "cards", "isForeignOnly", "isFoilOnly", "isNonFoilOnly",
                    "isOnlineOnly", "isPaperOnly", "isPartialPreview", "keyruneCode", "mcmId", "mcmIdExtras", "mcmName",
                    "mtgoCode", "name", "releaseDate", "parentCode", "tcgplayerGroupId", "tokens", "totalSetSize",
                    "translations", "type"
            })
    public Set(int baseSetSize,
               String block,
               String code,
               String codeV3,
               List<SetCard> cards,
               boolean isForeignOnly,
               boolean isFoilOnly,
               boolean isNonFoilOnly,
               boolean isOnlineOnly,
               boolean isPaperOnly,
               boolean isPartialPreview,
               String keyruneCode,
               Integer mcmId,
               Integer mcmIdExtras,
               String mcmName,
               String mtgoCode,
               String name,
               LocalDate releaseDate,
               String parentCode,
               Integer tcgplayerGroupId,
               List<TokenCard> tokens,
               Integer totalSetSize,
               Translations translations,
               Type type) {
        this.baseSetSize = baseSetSize;
        this.block = block;
        this.code = Objects.requireNonNull(code);
        this.codeV3 = codeV3;
        this.cards.addAll(cards);
        this.isForeignOnly = isForeignOnly;
        this.isFoilOnly = isFoilOnly;
        this.isNonFoilOnly = isNonFoilOnly;
        this.isOnlineOnly = isOnlineOnly;
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
        this.tcgplayerGroupId = tcgplayerGroupId;
        this.tokens.addAll(tokens);
        this.totalSetSize = Objects.requireNonNull(totalSetSize);
        this.translations = translations;
        this.type = Objects.requireNonNull(type);
    }

    /**
     * The number of cards in the set. Will default to totalSetSize if not available. Wizards of the Coast sometimes
     * prints extra cards beyond the set size into promos or supplemental products.
     *
     * @return The number of cards in the set.
     */
    public final Integer getBaseSetSize() {
        return baseSetSize;
    }

    /**
     * The block name the set was in.
     *
     * @return The block name the set was in.
     */
    public final String getBlock() {
        return block;
    }

    /**
     * The list of cards in the set. The returned list is unmodifiable.
     *
     * @return The list of cards in the set.
     * @see SetCard
     */
    public final List<SetCard> getCards() {
        return Collections.unmodifiableList(cards);
    }

    /**
     * The set code for the set.
     *
     * @return The set code for the set.
     */
    public final String getCode() {
        return code;
    }

    /**
     * The alternate set code Wizards of the Coast uses for a select few duel deck sets.
     *
     * @return The alternate set code Wizards of the Coast uses for a select few duel deck sets.
     */
    public final String getCodeV3() {
        return codeV3;
    }

    /**
     * If the set is only available in foil.
     *
     * @return If the set is only available in foil.
     */
    public final boolean isFoilOnly() {
        return isFoilOnly;
    }

    /**
     * If the set is available only outside the United States of America.
     *
     * @return If the set is available only outside the United States of America.
     */
    public final boolean isForeignOnly() {
        return isForeignOnly;
    }

    /**
     * If the set is only available in non-foil.
     *
     * @return If the set is only available in non-foil.
     */
    public final boolean isNonFoilOnly() {
        return isNonFoilOnly;
    }

    /**
     * If the set is only available online.
     *
     * @return If the set is only available online.
     */
    public final boolean isOnlineOnly() {
        return isOnlineOnly;
    }

    /**
     * If the set is available only in paper.
     *
     * @return If the set is available only in paper.
     */
    public final boolean isPaperOnly() {
        return isPaperOnly;
    }

    /**
     * If the set is still in preview (spoiled). Preview sets do not have complete data.
     *
     * @return If the set is still in preview (spoiled). Preview sets do not have complete data.
     */
    public final boolean isPartialPreview() {
        return isPartialPreview;
    }

    /**
     * The matching Keyrune code for <a href="https://keyrune.andrewgioia.com/">Keyrune</a> image icons.
     *
     * @return The matching Keyrune code for Keyrune image icons.
     */
    public final String getKeyruneCode() {
        return keyruneCode;
    }

    /**
     * The <a href="https://www.cardmarket.com/en/Magic">Magic Card Market</a> set identifier.
     *
     * @return The <a href="https://www.cardmarket.com/en/Magic">Magic Card Market</a> set identifier.
     */
    public final Integer getMcmId() {
        return mcmId;
    }

    /**
     * The split <a href="https://www.cardmarket.com/en/Magic">Magic Card Market</a> set identifier if a set is printed
     * in two sets. This identifier represents the second set's identifier.
     *
     * @return The split <a href="https://www.cardmarket.com/en/Magic">Magic Card Market</a> set identifier if a set is
     * printed in two sets.
     */
    public final Integer getMcmIdExtras() {
        return mcmIdExtras;
    }

    /**
     * The <a href="https://www.cardmarket.com/en/Magic">Magic Card Market</a> set name.
     *
     * @return The <a href="https://www.cardmarket.com/en/Magic">Magic Card Market</a> set name.
     */
    public final String getMcmName() {
        return mcmName;
    }

    /**
     * The set code for the set as it appears on <a href="https://magic.wizards.com/en/mtgo">Magic: The Gathering
     * Online</a>.
     *
     * @return The set code for the set as it appears on <a href="https://magic.wizards.com/en/mtgo">Magic: The
     * Gathering Online</a>.
     */
    public final String getMtgoCode() {
        return mtgoCode;
    }

    /**
     * The name of the set.
     *
     * @return The name of the set.
     */
    public final String getName() {
        return mtgoCode;
    }

    /**
     * The parent set code for set variations like promotions, guild kits, etc.
     *
     * @return The parent set code for set variations like promotions, guild kits, etc.
     */
    public final String getParentCode() {
        return parentCode;
    }

    /**
     * The release date for the set.
     *
     * @return The release date for the set.
     */
    public final LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * The group identifier of the set on <a href="https://www.tcgplayer.com">TCGplayer</a>.
     *
     * @return The group identifier of the set on <a href="https://www.tcgplayer.com">TCGplayer</a>.
     */
    public final Integer getTcgplayerGroupId() {
        return tcgplayerGroupId;
    }

    /**
     * The tokens available to the set. The returned list is unmodifiable.
     *
     * @return The tokens available to the set.
     */
    public final List<TokenCard> getTokens() {
        return Collections.unmodifiableList(tokens);
    }

    /**
     * The total number of cards in the set, including promos and related supplemental products.
     *
     * @return The total number of cards in the set, including promos and related supplemental products.
     */
    public final Integer getTotalSetSize() {
        return totalSetSize;
    }

    /**
     * The translated set name by language.
     *
     * @return The translated set name by language.
     */
    public final Translations getTranslations() {
        return translations;
    }

    /**
     * The expansion type of the set.
     *
     * @return The expansion type of the set.
     */
    public final Type getType() {
        return type;
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

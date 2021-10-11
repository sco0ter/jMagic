package mtgjson;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractCard {

    private final String artist;

    private final String asciiName;

    private final Set<Availability> availability;

    private final BorderColor borderColor;

    private final Set<Color> colorIdentity;

    private final Set<Color> colorIndicator;

    private final Set<Color> colors;

    private final Integer edhrecRank;

    private final String faceName;

    private final String flavorText;

    private final Set<FrameEffect> frameEffects;

    private final FrameVersion frameVersion;

    private final boolean hasFoil;

    private final boolean hasNonFoil;

    private final Identifiers identifiers;

    private final boolean isFullArt;

    private final boolean isOnlineOnly;

    private final boolean isPromo;

    private final boolean isReprint;

    private final List<String> keywords;

    private final Layout layout;

    private final String loyalty;

    //@JsonProperty(required = true)
    //private Legalities legalities;

    private final String name;

    private final String number;

    private final String power;

    private final List<String> promoTypes;

    private final String setCode;

    private final String side;

    private final List<String> subtypes;

    private final List<String> supertypes;

    private final String text;

    private final String toughness;

    private final String type;

    private final List<String> types;

    private final String uuid;

    private final String watermark;

    AbstractCard(String artist,
                 String asciiName,
                 Set<Availability> availabilities,
                 BorderColor borderColor,
                 Set<Color> colorIdentity,
                 Set<Color> colorIndicator,
                 Set<Color> colors,
                 Integer edhrecRank,
                 String faceName,
                 String flavorText,
                 Set<FrameEffect> frameEffects,
                 FrameVersion frameVersion,
                 boolean hasFoil,
                 boolean hasNonFoil,
                 Identifiers identifiers,
                 boolean isFullArt,
                 boolean isOnlineOnly,
                 boolean isPromo,
                 boolean isReprint,
                 List<String> keywords,
                 Layout layout,
                 String loyalty,
                 String name,
                 String number,
                 String power,
                 List<String> promoTypes,
                 String setCode,
                 String side,
                 List<String> subtypes,
                 List<String> supertypes,
                 String text,
                 String toughness,
                 String type,
                 List<String> types,
                 String uuid,
                 String watermark) {
        this.artist = artist;
        this.asciiName = asciiName;
        this.availability = availabilities;
        this.borderColor = borderColor;
        this.colorIdentity = Set.copyOf(colorIdentity);
        this.colorIndicator = colorIndicator != null ? Set.copyOf(colorIndicator) : Collections.emptySet();
        this.colors = Set.copyOf(colors);
        this.edhrecRank = edhrecRank;
        this.faceName = faceName;
        this.flavorText = flavorText;
        this.frameEffects = frameEffects != null ? Set.copyOf(frameEffects) : Collections.emptySet();
        this.frameVersion = frameVersion;
        this.hasFoil = hasFoil;
        this.hasNonFoil = hasNonFoil;
        this.identifiers = identifiers;
        this.isFullArt = isFullArt;
        this.isOnlineOnly = isOnlineOnly;
        this.isPromo = isPromo;
        this.isReprint = isReprint;
        this.keywords = keywords;
        this.layout = layout;
        this.loyalty = loyalty;
        this.name = name;
        this.number = number;
        this.power = power;
        this.promoTypes = promoTypes;
        this.setCode = setCode;
        this.side = side;
        this.subtypes = subtypes;
        this.supertypes = supertypes;
        this.text = text;
        this.toughness = toughness;
        this.type = type;
        this.types = types;
        this.uuid = uuid;
        this.watermark = watermark;
    }

    /**
     * The name of the artist that illustrated the card art.
     *
     * @return The name of the artist that illustrated the card art.
     */
    public final Optional<String> getArtist() {
        return Optional.ofNullable(artist);
    }

    /**
     * The ASCII (Basic/128) code formatted card name with no special unicode characters.
     *
     * @return The ASCII (Basic/128) code formatted card name with no special unicode characters.
     */
    public final Optional<String> getAsciiName() {
        return Optional.ofNullable(asciiName);
    }

    /**
     * The card's available printing types.
     *
     * @return The card's available printing types.
     */
    public final Set<Availability> getAvailabilities() {
        return availability;
    }

    /**
     * The color of the card border.
     *
     * @return The color of the card border.
     */
    public final BorderColor getBorderColor() {
        return borderColor;
    }

    /**
     * A list of all the colors found in manaCost, colorIndicator, and text.
     *
     * @return A list of all the colors found in manaCost, colorIndicator, and text.
     */
    public final Set<Color> getColorIdentity() {
        return colorIdentity;
    }

    /**
     * A list of all the colors in the color indicator (The symbol prefixed to a card's types).
     *
     * @return A list of all the colors in the color indicator (The symbol prefixed to a card's types).
     */
    public final Set<Color> getColorIndicator() {
        return colorIndicator;
    }

    /**
     * A list of all the colors in manaCost and colorIndicator. Some cards may not have a value, such as cards with
     * "Devoid" in its text.
     *
     * @return A list of all the colors in manaCost and colorIndicator.
     */
    public final Set<Color> getColors() {
        return colors;
    }

    /**
     * The card rank on <a href="https://www.edhrec.com/">EDHRec</a>.
     *
     * @return The card rank on <a href="https://www.edhrec.com/">EDHRec</a>.
     */
    public final Optional<Integer> getEdhrecRank() {
        return Optional.ofNullable(edhrecRank);
    }

    /**
     * The name on the face of the card.
     *
     * @return The name on the face of the card.
     */
    public final Optional<String> getFaceName() {
        return Optional.ofNullable(faceName);
    }

    /**
     * The italicized text found below the rules text that has no game function.
     *
     * @return The italicized text found below the rules text that has no game function.
     */
    public final Optional<String> getFlavorText() {
        return Optional.ofNullable(flavorText);
    }

    /**
     * The visual frame effects.
     *
     * @return The visual frame effects.
     */
    public final Set<FrameEffect> getFrameEffects() {
        return frameEffects;
    }

    /**
     * The version of the card frame style.
     *
     * @return The version of the card frame style.
     */
    public final FrameVersion getFrameVersion() {
        return frameVersion;
    }

    /**
     * If the card be found in foil.
     *
     * @return If the card be found in foil.
     */
    public final boolean hasFoil() {
        return hasFoil;
    }

    /**
     * If the card can be found in non-foil.
     *
     * @return If the card can be found in non-foil.
     */
    public final boolean hasNonFoil() {
        return hasNonFoil;
    }

    /**
     * A list of identifiers associated to a card. See the Identifiers data model.
     *
     * @return A list of identifiers associated to a card. See the Identifiers data model.
     */
    public final Identifiers getIdentifiers() {
        return identifiers;
    }

    /**
     * If the card has full artwork.
     *
     * @return If the card has full artwork.
     */
    public final boolean isFullArt() {
        return isFullArt;
    }

    /**
     * If the card is only available in <a href="https://magic.wizards.com/en/mtgo">Magic: The Gathering Online</a>.
     *
     * @return If the card is only available in <a href="https://magic.wizards.com/en/mtgo">Magic: The Gathering
     * Online</a>.
     */
    public final boolean isOnlineOnly() {
        return isOnlineOnly;
    }

    /**
     * If the card is promotional.
     *
     * @return If the card is promotional.
     */
    public final boolean isPromo() {
        return isPromo;
    }

    /**
     * If the card has been reprinted.
     *
     * @return If the card has been reprinted.
     */
    public final boolean isReprint() {
        return isReprint;
    }

    /**
     * A list of keywords found on the card.
     *
     * @return A list of keywords found on the card.
     */
    public final List<String> getKeywords() {
        return keywords;
    }

    /**
     * The type of card layout. For a token card, this will be "token".
     *
     * @return The type of card layout. For a token card, this will be "token".
     */
    public final Layout getLayout() {
        return layout;
    }

    /**
     * The loyalty value of the card. Used on Planeswalker cards.
     *
     * @return The loyalty value of the card. Used on Planeswalker cards.
     */
    public final Optional<String> getLoyalty() {
        return Optional.ofNullable(loyalty);
    }

    /**
     * The name of the card. Cards with multiple faces, like "Split" and "Meld" cards are given a delimiter.
     *
     * @return The name of the card.
     */
    public final String getName() {
        return name;
    }

    /**
     * The number of the card. Can be prefixed or suffixed with a * or other characters for promo sets.
     *
     * @return The number of the card.
     */
    public final String getNumber() {
        return number;
    }

    /**
     * The power of the card.
     *
     * @return The power of the card.
     */
    public final Optional<String> getPower() {
        return Optional.ofNullable(power);
    }

    /**
     * A list of promotional types for a card.
     *
     * @return A list of promotional types for a card.
     */
    public final List<String> getPromoTypes() {
        return promoTypes;
    }

    /**
     * The set code of the card.
     *
     * @return The set code of the card.
     */
    public final String getSetCode() {
        return setCode;
    }

    /**
     * The identifier of the card side. Used on cards with multiple faces.
     *
     * @return The identifier of the card side. Used on cards with multiple faces.
     */
    public final Optional<String> getSide() {
        return Optional.ofNullable(side);
    }

    /**
     * A list of card subtypes found after em-dash.
     *
     * @return A list of card subtypes found after em-dash.
     */
    public final List<String> getSubtypes() {
        return subtypes;
    }

    /**
     * A list of card supertypes found before em-dash.
     *
     * @return A list of card supertypes found before em-dash.
     */
    public final List<String> getSupertypes() {
        return supertypes;
    }

    /**
     * The rules text of the card.
     *
     * @return The rules text of the card.
     */
    public final Optional<String> getText() {
        return Optional.ofNullable(text);
    }

    /**
     * The toughness of the card.
     *
     * @return The toughness of the card.
     */
    public final Optional<String> getToughness() {
        return Optional.ofNullable(toughness);
    }

    /**
     * Type of the card as visible, including any supertypes and subtypes.
     *
     * @return Type of the card as visible, including any supertypes and subtypes.
     */
    public final String getType() {
        return type;
    }

    /**
     * A list of all card types of the card, including Un‑sets and gameplay variants.
     *
     * @return A list of all card types of the card, including Un‑sets and gameplay variants.
     */
    public final List<String> getTypes() {
        return types;
    }

    /**
     * The universal unique identifier (v5) generated by MTGJSON. Each entry is unique.
     *
     * @return The universal unique identifier (v5) generated by MTGJSON. Each entry is unique.
     */
    public final String getUuid() {
        return uuid;
    }

    /**
     * The name of the watermark on the card.
     *
     * @return The name of the watermark on the card.
     */
    public final Optional<String> getWatermark() {
        return Optional.ofNullable(watermark);
    }

    @Override
    public String toString() {
        return name;
    }
}

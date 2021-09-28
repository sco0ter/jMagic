package mtgjson;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ICard {

    Optional<String> getArtist();

    Optional<String> getAsciiName();

    Availability getAvailability();

    BorderColor getBorderColor();

    Color getColorIdentity();

    Optional<Color> getColorIndicator();

    List<Color> getColors();

    float getConvertedManaCost();

    Optional<Integer> getEdhrecRank();

    Optional<Float> getFaceConvertedManaCost();

    Optional<Float> getFaceName();

    Optional<String> getFlavorName();

    Optional<String> getFlavorText();

    List<ForeignData> getForeignData();

    List<FrameEffect> getFrameEffects();

    String getFrameVersion();

    Optional<String> getHand();

    Optional<Boolean> hasContentWarning();

    boolean hasFoil();

    Optional<Boolean> hasAlternativeDeckLimit();

    boolean hasNonFoil();

    List<Identifiers> getIdentifiers();

    Optional<Boolean> isAlternative();

    Optional<Boolean> isFullArt();

    Optional<Boolean> isOnlineOnly();

    Optional<Boolean> isOversized();

    Optional<Boolean> isPromo();

    Optional<Boolean> isReprint();

    Optional<Boolean> isReserved();

    Optional<Boolean> isStarter();

    Optional<Boolean> isStorySpotlight();

    Optional<Boolean> isTextless();

    Optional<Boolean> isTimeshifted();

    List<String> getKeywords();

    Layout getLayout();

    Optional<String> getLeadershipSkills();

    List<String> getLegalities();

    Optional<String> getLife();

    Optional<String> getLoyalty();

    Optional<String> getManaCost();

    String getName();

    String getNumber();

    Optional<LocalDate> getOriginalReleaseDate();

    Optional<String> getOriginalText();

    Optional<String> getOriginalType();

    List<String> getOtherFaceIds();

    Optional<String> getPower();

    List<String> getPrintings();

    List<PromoType> getPromoTypes();

    List<String> getPurchaseUrls();

    String getRarity();

    List<String> getRulings();

    String getSetCode();

    Optional<String> getSide();

    List<String> getSubtypes();

    List<String> getSupertypes();

    Optional<String> getText();

    Optional<String> getToughness();

    String getType();

    List<String> getTypes();

    String getUuid();

    List<String> getVariations();

    Optional<String> getWatermark();
}

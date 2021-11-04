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

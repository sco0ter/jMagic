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

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import liquibase.exception.LiquibaseException;
import mtgjson.Availability;
import mtgjson.BorderColor;
import mtgjson.DatabaseUtil;
import mtgjson.Finish;
import mtgjson.FrameVersion;
import mtgjson.Layout;
import mtgjson.MtgJsonParser;
import mtgjson.Set;
import mtgjson.SetCard;
import org.h2.jdbcx.JdbcDataSource;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MtgDaoTest {

    private DatabaseUtil mtgDao;

    @BeforeClass
    public void initDatabase() throws SQLException, LiquibaseException, IOException {

        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL("jdbc:h2:mem:Magic;DB_CLOSE_DELAY=-1");
        mtgDao = new DatabaseUtil(jdbcDataSource);
        mtgDao.init();
        try (InputStream inputStream = getClass().getResourceAsStream("MRD.json")) {
            Optional<Set> optionalSet = MtgJsonParser.parseSet(inputStream);
            mtgDao.insert(optionalSet.orElseThrow());
        }
    }

    @Test
    public void findCardsByName() throws SQLException {
        List<SetCard> cards = mtgDao.findCardsByName("Chrome Mox");
        Assert.assertEquals(cards.size(), 1);
        SetCard chromeMox = cards.get(0);
        Assert.assertEquals(chromeMox.getArtist(), "Donato Giancola");
        Assert.assertNull(chromeMox.getAsciiName());
        Assert.assertEquals(chromeMox.getAvailabilities().size(), 2);
        Assert.assertTrue(chromeMox.getAvailabilities().contains(Availability.MTGO));
        Assert.assertTrue(chromeMox.getAvailabilities().contains(Availability.PAPER));
        Assert.assertEquals(chromeMox.getBorderColor(), BorderColor.BLACK);
        Assert.assertTrue(chromeMox.getColorIdentity().isEmpty());
        Assert.assertTrue(chromeMox.getColorIndicator().isEmpty());
        Assert.assertNull(chromeMox.getFaceName());
        Assert.assertEquals(chromeMox.getFaceManaValue(), 0);
        Assert.assertEquals(chromeMox.getFinishes().size(), 2);
        Assert.assertTrue(chromeMox.getFinishes().contains(Finish.FOIL));
        Assert.assertTrue(chromeMox.getFinishes().contains(Finish.NONFOIL));
        Assert.assertNull(chromeMox.getFlavorName());
        Assert.assertNull(chromeMox.getFlavorText());
        Assert.assertEquals(chromeMox.getForeignData().size(), 6);
        Assert.assertTrue(chromeMox.getFrameEffects().isEmpty());
        Assert.assertEquals(chromeMox.getFrameVersion(), FrameVersion._2003);
        Assert.assertNull(chromeMox.getHand());
        Assert.assertFalse(chromeMox.hasContentWarning());
        Assert.assertFalse(chromeMox.hasAlternativeDeckLimit());
        Assert.assertNotNull(chromeMox.getIdentifiers());
        Assert.assertFalse(chromeMox.isAlternative());
        Assert.assertFalse(chromeMox.isFullArt());
        Assert.assertFalse(chromeMox.isOnlineOnly());
        Assert.assertFalse(chromeMox.isOversized());
        Assert.assertFalse(chromeMox.isPromo());
        Assert.assertFalse(chromeMox.isReprint());
        Assert.assertFalse(chromeMox.isReserved());
        Assert.assertFalse(chromeMox.isStarter());
        Assert.assertFalse(chromeMox.isStorySpotlight());
        Assert.assertFalse(chromeMox.isTextless());
        Assert.assertFalse(chromeMox.isTimeshifted());
        Assert.assertEquals(chromeMox.getLayout(), Layout.NORMAL);
        Assert.assertNull(chromeMox.getLife());
        Assert.assertNull(chromeMox.getLoyalty());
        Assert.assertEquals(chromeMox.getManaCost(), "{0}");
        Assert.assertEquals(chromeMox.getManaValue(), 0);
        Assert.assertEquals(chromeMox.getName(), "Chrome Mox");
        Assert.assertEquals(chromeMox.getNumber(), "152");
        Assert.assertEquals(chromeMox.getOriginalText(),
                "Imprint When Chrome Mox comes into play, you may remove a nonartifact, nonland card in your hand from the game. (The removed card is imprinted on this artifact.)\n"
                        + "{T}: Add one mana of any of the imprinted card's colors to your mana pool.");
        Assert.assertEquals(chromeMox.getOriginalType(), "Artifact");
        Assert.assertEquals(chromeMox.getSetCode(), "MRD");
        Assert.assertNull(chromeMox.getSide());
        Assert.assertEquals(chromeMox.getType(), "Artifact");
        Assert.assertNull(chromeMox.getUuid());
        Assert.assertNull(chromeMox.getWatermark());
    }

    @Test
    public void findSets() throws SQLException {
        List<Set> sets = mtgDao.findSets();
        Assert.assertEquals(sets.size(), 1);
        Set set = sets.get(0);
        Assert.assertEquals(set.getCards().size(), set.getTotalSetSize());
        Assert.assertEquals(set.getCode(), "MRD");
        Assert.assertEquals(set.getBaseSetSize(), 306);
        Assert.assertEquals(set.getBlock(), "Mirrodin");
        Assert.assertNull(set.getCodeV3());
        Assert.assertEquals(set.getKeyruneCode(), "MRD");
        Assert.assertEquals(set.getMcmId(), Integer.valueOf(45));
        Assert.assertEquals(set.getMcmName(), "Mirrodin");
        Assert.assertEquals(set.getMtgoCode(), "MRD");
        Assert.assertEquals(set.getName(), "Mirrodin");
        Assert.assertEquals(set.getReleaseDate(), LocalDate.of(2003, Month.OCTOBER, 2));
        Assert.assertEquals(set.getTcgplayerGroupId(), Integer.valueOf(75));
        Assert.assertEquals(set.getTotalSetSize(), 306);
        Assert.assertEquals(set.getType(), Set.Type.EXPANSION);
    }
}

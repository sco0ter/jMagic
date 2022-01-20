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
import java.time.LocalDate;
import java.util.Optional;

import mtgjson.MtgJsonParser;
import mtgjson.Set;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MtgJsonParserTest {

    @Test
    public void testParse() throws IOException {

        try (InputStream inputStream = getClass().getResourceAsStream("MRD.json")) {
            Optional<Set> optionalSet = MtgJsonParser.parseSet(inputStream);
            Assert.assertTrue(optionalSet.isPresent());
            Set set = optionalSet.get();
            Assert.assertEquals(set.getName(), "Mirrodin");
            Assert.assertEquals(set.getCode(), "MRD");
            Assert.assertEquals(set.getReleaseDate(), LocalDate.of(2003, 10, 2));
            Assert.assertEquals(set.getCards().size(), 306);
        }
    }
}

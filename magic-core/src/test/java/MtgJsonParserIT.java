import mtgjson.MtgJsonParser;
import mtgjson.Set;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MtgJsonParserIT {

    @Test
    public void testParse() throws IOException {
        try (InputStream inputStream = Files.newInputStream(Paths.get("./AllPrintings.json"))) {
            List<Set> sets = MtgJsonParser.parse(inputStream);

            Assert.assertNotNull(sets);
        }
    }
}

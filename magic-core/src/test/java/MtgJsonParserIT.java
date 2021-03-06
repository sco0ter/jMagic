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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.stream.Stream;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.exception.LiquibaseException;
import mtgjson.DatabaseUtil;
import mtgjson.MtgJsonParser;
import mtgjson.Set;
import org.testng.annotations.Test;

public class MtgJsonParserIT {

    private static final HikariDataSource ds;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:file:./Magic");
        ds = new HikariDataSource(config);
    }

    @Test
    public void testParse() throws IOException, SQLException, LiquibaseException {

        DatabaseUtil db = new DatabaseUtil(ds);
        db.init();
        try (InputStream inputStream = Files.newInputStream(Paths.get("./AllPrintings.json"))) {
            Stream<Set> sets = MtgJsonParser.parseAllPrintings(inputStream);
            sets.forEach(set -> {
                try {
                    db.insert(set);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

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

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class MtgJsonParser {

    private MtgJsonParser() {
    }

    public static Stream<Set> parseAllPrintings(InputStream inputStream) throws IOException {
        return parse(inputStream, true);
    }

    public static Optional<Set> parseSet(InputStream inputStream) throws IOException {
        return parse(inputStream, false).findFirst();
    }

    private static Stream<Set> parse(InputStream inputStream, boolean skip) throws IOException {

        ObjectMapper mapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        JsonParser parser = mapper.getFactory().createParser(inputStream);

        // move to start of document
        parser.nextValue();
        // move to "meta" element
        parser.nextValue();
        // skip "meta" element
        parser.skipChildren();

        if (skip) {
            parser.nextValue();
        }
        return StreamSupport.stream(new MtgJsonSpliterator(parser), false);
    }

    private static final class MtgJsonSpliterator extends Spliterators.AbstractSpliterator<Set> {

        private final JsonParser parser;

        private MtgJsonSpliterator(JsonParser parser) {
            super(Long.MAX_VALUE,
                    Spliterator.DISTINCT | Spliterator.NONNULL | Spliterator.SIZED | Spliterator.IMMUTABLE);
            this.parser = parser;
        }

        @Override
        public boolean tryAdvance(Consumer<? super Set> action) {
            try {
                if (parser.nextValue() != null) {
                    Set set = parser.readValueAs(Set.class);
                    if (set != null) {
                        action.accept(set);
                    }
                    return true;
                }
                return false;
            } catch (IOException e) {
                return false;
            }
        }
    }
}

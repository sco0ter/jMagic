import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class MtgJsonParser {

    public static List<Set> parse(InputStream inputStream) throws IOException {
        List<Set> sets = new ArrayList<>();

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
        // move to end of "meta" element
        parser.nextValue();

        // move to first value of "data" element
        while (parser.nextValue() != null) {
            Set set = parser.readValueAs(Set.class);
            sets.add(set);
        }
        return sets;
    }
}

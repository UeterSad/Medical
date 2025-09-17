package com.orgthirteen.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

    private static final List<String> DATE_FORMATS = Arrays.asList(
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd"
    );

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        String date = jsonParser.getText();
        for (String format : DATE_FORMATS) {
            try {
                // It's important to set the timezone to avoid unexpected shifts
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setTimeZone(deserializationContext.getTimeZone());
                return sdf.parse(date);
            } catch (ParseException e) {
                // Ignore and try the next format
            }
        }
        throw new IOException("Unable to parse date: \"" + date + "\". Supported formats: " + DATE_FORMATS);
    }
}

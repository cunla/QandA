package com.delirium.boiler.tools;

import com.fasterxml.jackson.datatype.joda.cfg.FormatConfig;
import com.fasterxml.jackson.datatype.joda.deser.DateTimeDeserializer;
import org.joda.time.DateTime;

/**
 * Created by style on 29/01/2017.
 */
public class BoilerDateTimeDeserializer extends DateTimeDeserializer {
    public BoilerDateTimeDeserializer() {
        super(DateTime.class, FormatConfig.DEFAULT_DATETIME_PARSER);
    }
}

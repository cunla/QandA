package com.delirium.boiler.tools;

import com.fasterxml.jackson.datatype.joda.cfg.FormatConfig;
import com.fasterxml.jackson.datatype.joda.cfg.JacksonJodaDateFormat;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;

/**
 * Created by style on 29/01/2017.
 */
public class BoilerDateTimeSerializer extends DateTimeSerializer {
    public BoilerDateTimeSerializer() {
        super(FormatConfig.DEFAULT_DATETIME_PARSER);
    }

}

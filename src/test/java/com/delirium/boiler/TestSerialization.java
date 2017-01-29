package com.delirium.boiler;

import com.delirium.boiler.question.domain.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * Created by style on 29/01/2017.
 */
public class TestSerialization {
    @Test
    @SuppressWarnings("unchecked")
    public void testJsonSerialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Question serializationValue = new Question("daniel", "title", "body");
        // Serialize test object
        String json = mapper.writeValueAsString(serializationValue);
        // Test that object was serialized as expected
        System.out.println(json);
        // Deserialize to complete round trip
        Question roundTrip = mapper.readValue(json, serializationValue.getClass());
        // Validate that the deserialized object matches the original one
        System.out.println(roundTrip);
    }
}

package com.voidtracker.oms.commons.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;

class ApiErrorDtoRoundTripTest {
    @Test
    void apiErrorDtoShouldSerializeAndDeserializeRoundTrip() throws Exception {
        String exampleJson = new String(
            getClass().getResourceAsStream("/schemas/json/example/ApiErrorDto_example.json").readAllBytes(),
            StandardCharsets.UTF_8
        );
        ObjectMapper mapper = new ObjectMapper();
        ApiErrorDto dto = mapper.readValue(exampleJson, ApiErrorDto.class);
        String serialized = mapper.writeValueAsString(dto);
        ApiErrorDto roundTrip = mapper.readValue(serialized, ApiErrorDto.class);
        assertEquals(dto, roundTrip);
    }
}

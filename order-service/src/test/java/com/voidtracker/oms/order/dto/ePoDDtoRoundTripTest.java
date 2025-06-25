package com.voidtracker.oms.order.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;

class EpodDtoRoundTripTest {
    @Test
    void epodDtoShouldSerializeAndDeserializeRoundTrip() throws Exception {
        try (var is = getClass().getClassLoader().getResourceAsStream("schema/example/ePoDDto_example.json")) {
            assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            OrderDto.EpodDto dto = mapper.readValue(exampleJson, OrderDto.EpodDto.class);
            String serialized = mapper.writeValueAsString(dto);
            OrderDto.EpodDto roundTrip = mapper.readValue(serialized, OrderDto.EpodDto.class);
            assertEquals(dto, roundTrip);
        }
    }
}

package com.voidtracker.oms.user.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserProfileDtoRoundTripTest {
    @Test
    public void userProfileDtoShouldSerializeAndDeserializeRoundTrip() throws Exception {
        try (var is = getClass().getClassLoader().getResourceAsStream("schemas/json/example/UserProfileDto_example.json")) {
            org.junit.jupiter.api.Assertions.assertNotNull(is, "Example JSON file not found in classpath");
            String exampleJson = new String(is.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            UserProfileDto dto = mapper.readValue(exampleJson, UserProfileDto.class);
            String serialized = mapper.writeValueAsString(dto);
            UserProfileDto roundTrip = mapper.readValue(serialized, UserProfileDto.class);
            assertEquals(dto, roundTrip);
        }
    }
}

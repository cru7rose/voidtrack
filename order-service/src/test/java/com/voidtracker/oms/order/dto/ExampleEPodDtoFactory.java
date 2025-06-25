package com.voidtracker.oms.order.dto;

import com.voidtracker.oms.order.dto.OrderDto.EpodDto;
import java.time.OffsetDateTime;
import java.util.Collections;

public class ExampleEPodDtoFactory {
    public static EpodDto createExampleEpodDto() {
        return new EpodDto(
            "epod-1", // id
            "a1b2c3d4-e5f6-7890-1234-567890abcdef", // orderId
            "base64signature", // signature
            Collections.singletonList("base64photo"), // photos
            OffsetDateTime.parse("2024-06-10T08:10:00Z"), // timestamp
            "john_doe" // userId
        );
    }
}

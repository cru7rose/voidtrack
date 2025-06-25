package com.voidtracker.oms.order.dto;

import java.time.OffsetDateTime;
import java.util.List;

public record EPoDDto(
    String id,
    String orderId,
    String signature,
    List<String> photos,
    OffsetDateTime timestamp,
    String userId
) {}

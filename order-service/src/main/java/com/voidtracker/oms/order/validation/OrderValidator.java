package com.voidtracker.oms.order.validation;

import com.voidtracker.oms.order.dto.CreateOrderRequestDto;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {
    public boolean isValid(CreateOrderRequestDto request) {
        // TODO: Implement validation logic (e.g., required fields, business rules)
        return true;
    }
}

package com.voidtracker.oms.order.eco;

import lombok.Data;

@Data
public class EcoRouteSuggestionDto {
    private String suggestionId;
    private String orderId;
    private double estimatedCo2Saved;
    private String suggestedRoute;
    private String generatedAt;
}

package com.voidtracker.oms.order.route;

import lombok.Data;
import java.util.List;

@Data
public class RouteOptimizationDto {
    private String optimizationId;
    private List<String> orderIds;
    private String optimizationType; // e.g., FASTEST, ECO, CHEAPEST
    private String resultSummary;
    private String generatedAt;
}

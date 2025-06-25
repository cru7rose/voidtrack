package com.voidtracker.oms.order.route;

import lombok.Data;
import java.util.List;

@Data
public class RouteDto {
    private String routeId;
    private List<String> waypoints;
    private double distanceKm;
    private double estimatedTimeMin;
    private String optimizationType; // e.g., FASTEST, SHORTEST
}

package com.voidtracker.oms.order.route;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class RouteOptimizationRepository {
    private final Map<String, RouteOptimizationDto> optimizations = new HashMap<>();

    public void save(RouteOptimizationDto optimization) { optimizations.put(optimization.getOptimizationId(), optimization); }
    public Optional<RouteOptimizationDto> findById(String optimizationId) { return Optional.ofNullable(optimizations.get(optimizationId)); }
    public List<RouteOptimizationDto> findAll() { return new ArrayList<>(optimizations.values()); }
}

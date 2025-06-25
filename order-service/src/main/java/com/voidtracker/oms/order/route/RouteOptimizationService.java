package com.voidtracker.oms.order.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RouteOptimizationService {
    @Autowired
    private RouteOptimizationRepository routeOptimizationRepository;

    public void saveOptimization(RouteOptimizationDto optimization) {
        routeOptimizationRepository.save(optimization);
    }

    public List<RouteOptimizationDto> getAllOptimizations() {
        return routeOptimizationRepository.findAll();
    }
}

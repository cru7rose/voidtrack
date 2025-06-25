package com.voidtracker.oms.order.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/route/optimizations")
public class RouteOptimizationController {
    @Autowired
    private RouteOptimizationService routeOptimizationService;

    @GetMapping
    public List<RouteOptimizationDto> getAllOptimizations() {
        return routeOptimizationService.getAllOptimizations();
    }
}

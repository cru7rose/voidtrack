package com.voidtracker.oms.order.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/route")
public class RoutePlanningController {
    @Autowired
    private RoutePlanningService routePlanningService;

    // TODO: Implement endpoints for route calculation, optimization, and integration with OSRM/GraphHopper
}

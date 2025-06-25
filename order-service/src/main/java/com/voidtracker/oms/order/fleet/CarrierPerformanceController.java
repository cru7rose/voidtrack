package com.voidtracker.oms.order.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fleet/carrier-performance")
public class CarrierPerformanceController {
    @Autowired
    private CarrierPerformanceService carrierPerformanceService;

    @GetMapping
    public List<CarrierPerformanceDto> getAllPerformances() {
        return carrierPerformanceService.getAllPerformances();
    }
}

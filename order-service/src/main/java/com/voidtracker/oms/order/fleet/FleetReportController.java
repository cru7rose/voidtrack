package com.voidtracker.oms.order.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fleet/reports")
public class FleetReportController {
    @Autowired
    private FleetReportService fleetReportService;

    @GetMapping
    public List<FleetReportDto> getAllReports() {
        return fleetReportService.getAllReports();
    }
}

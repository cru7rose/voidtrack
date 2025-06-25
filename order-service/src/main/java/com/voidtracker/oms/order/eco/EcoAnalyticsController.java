package com.voidtracker.oms.order.eco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/eco")
public class EcoAnalyticsController {
    @Autowired
    private EcoAnalyticsServiceImpl ecoAnalyticsService;

    @GetMapping("/reports")
    public List<EcoReportDto> getAllEcoReports() {
        return ecoAnalyticsService.getAllEcoReports();
    }
}

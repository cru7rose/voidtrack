package com.voidtracker.oms.order.analytics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/analytics/reports")
public class AnalyticsReportController {
    @Autowired
    private AnalyticsReportService analyticsReportService;

    @GetMapping
    public List<AnalyticsReportDto> getAllReports() {
        return analyticsReportService.getAllReports();
    }
}

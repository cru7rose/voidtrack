package com.voidtracker.oms.order.analytics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/analytics/kpi")
public class AnalyticsKpiController {
    @Autowired
    private AnalyticsKpiService analyticsKpiService;

    @GetMapping
    public List<AnalyticsKpiDto> getAllKpis() {
        return analyticsKpiService.getAllKpis();
    }
}

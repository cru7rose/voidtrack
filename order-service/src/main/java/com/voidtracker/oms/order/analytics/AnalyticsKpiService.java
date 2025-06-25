package com.voidtracker.oms.order.analytics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnalyticsKpiService {
    @Autowired
    private AnalyticsKpiRepository analyticsKpiRepository;

    // TODO: Implement KPI calculation and reporting logic
    public void saveKpi(AnalyticsKpiDto kpi) {
        analyticsKpiRepository.save(kpi);
    }

    public List<AnalyticsKpiDto> getAllKpis() {
        return analyticsKpiRepository.findAll();
    }
}

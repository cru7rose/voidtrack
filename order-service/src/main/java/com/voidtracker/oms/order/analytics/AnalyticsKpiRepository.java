package com.voidtracker.oms.order.analytics;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class AnalyticsKpiRepository {
    private final Map<String, AnalyticsKpiDto> kpis = new HashMap<>();

    public void save(AnalyticsKpiDto kpi) { kpis.put(kpi.getKpiName(), kpi); }
    public Optional<AnalyticsKpiDto> findByName(String kpiName) { return Optional.ofNullable(kpis.get(kpiName)); }
    public List<AnalyticsKpiDto> findAll() { return new ArrayList<>(kpis.values()); }
}

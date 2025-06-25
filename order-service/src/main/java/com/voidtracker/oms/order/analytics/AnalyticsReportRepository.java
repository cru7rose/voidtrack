package com.voidtracker.oms.order.analytics;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class AnalyticsReportRepository {
    private final Map<String, AnalyticsReportDto> reports = new HashMap<>();

    public void save(AnalyticsReportDto report) { reports.put(report.getReportId(), report); }
    public Optional<AnalyticsReportDto> findById(String reportId) { return Optional.ofNullable(reports.get(reportId)); }
    public List<AnalyticsReportDto> findAll() { return new ArrayList<>(reports.values()); }
}

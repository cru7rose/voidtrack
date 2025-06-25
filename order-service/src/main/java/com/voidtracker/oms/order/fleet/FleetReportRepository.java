package com.voidtracker.oms.order.fleet;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class FleetReportRepository {
    private final Map<String, FleetReportDto> reports = new HashMap<>();

    public void save(FleetReportDto report) { reports.put(report.getReportId(), report); }
    public Optional<FleetReportDto> findById(String reportId) { return Optional.ofNullable(reports.get(reportId)); }
    public List<FleetReportDto> findAll() { return new ArrayList<>(reports.values()); }
}

package com.voidtracker.oms.order.eco;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EcoReportRepository {
    private final Map<String, EcoReportDto> reports = new HashMap<>();

    public void save(EcoReportDto report) { reports.put(report.getOrderId(), report); }
    public Optional<EcoReportDto> findByOrderId(String orderId) { return Optional.ofNullable(reports.get(orderId)); }
    public List<EcoReportDto> findAll() { return new ArrayList<>(reports.values()); }
}

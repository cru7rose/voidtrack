package com.voidtracker.oms.order.analytics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnalyticsReportService {
    @Autowired
    private AnalyticsReportRepository analyticsReportRepository;

    public void saveReport(AnalyticsReportDto report) {
        analyticsReportRepository.save(report);
    }

    public List<AnalyticsReportDto> getAllReports() {
        return analyticsReportRepository.findAll();
    }
}

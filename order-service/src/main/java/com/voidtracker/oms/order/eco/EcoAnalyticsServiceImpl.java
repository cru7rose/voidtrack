package com.voidtracker.oms.order.eco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EcoAnalyticsServiceImpl extends EcoAnalyticsService {
    @Autowired
    private EcoReportRepository ecoReportRepository;

    // TODO: Implement CO2/emission analytics and eco route suggestions
    public void saveEcoReport(EcoReportDto report) {
        ecoReportRepository.save(report);
    }

    public List<EcoReportDto> getAllEcoReports() {
        return ecoReportRepository.findAll();
    }
}

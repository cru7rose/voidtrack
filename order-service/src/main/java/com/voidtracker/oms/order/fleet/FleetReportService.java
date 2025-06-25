package com.voidtracker.oms.order.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FleetReportService {
    @Autowired
    private FleetReportRepository fleetReportRepository;

    public void saveReport(FleetReportDto report) {
        fleetReportRepository.save(report);
    }

    public List<FleetReportDto> getAllReports() {
        return fleetReportRepository.findAll();
    }
}

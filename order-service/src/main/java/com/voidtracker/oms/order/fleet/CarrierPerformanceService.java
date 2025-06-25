package com.voidtracker.oms.order.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarrierPerformanceService {
    @Autowired
    private CarrierPerformanceRepository carrierPerformanceRepository;

    public void savePerformance(CarrierPerformanceDto perf) {
        carrierPerformanceRepository.save(perf);
    }

    public List<CarrierPerformanceDto> getAllPerformances() {
        return carrierPerformanceRepository.findAll();
    }
}

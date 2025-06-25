package com.voidtracker.oms.order.fleet;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CarrierPerformanceRepository {
    private final Map<String, CarrierPerformanceDto> performances = new HashMap<>();

    public void save(CarrierPerformanceDto perf) { performances.put(perf.getCarrierId(), perf); }
    public Optional<CarrierPerformanceDto> findByCarrierId(String carrierId) { return Optional.ofNullable(performances.get(carrierId)); }
    public List<CarrierPerformanceDto> findAll() { return new ArrayList<>(performances.values()); }
}

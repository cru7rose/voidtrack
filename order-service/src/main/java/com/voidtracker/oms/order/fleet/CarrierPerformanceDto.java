package com.voidtracker.oms.order.fleet;

import lombok.Data;

@Data
public class CarrierPerformanceDto {
    private String carrierId;
    private double onTimeRate;
    private double costPerKm;
    private double qualityScore;
    private String period;
}

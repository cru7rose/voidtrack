package com.voidtracker.oms.order.eco;

import lombok.Data;

@Data
public class EcoReportDto {
    private String orderId;
    private double co2Emission;
    private String unit;
    private String reportPeriod;
}

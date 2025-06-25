package com.voidtracker.oms.order.analytics;

import lombok.Data;

@Data
public class AnalyticsKpiDto {
    private String kpiName;
    private double value;
    private String unit;
    private String period;
}

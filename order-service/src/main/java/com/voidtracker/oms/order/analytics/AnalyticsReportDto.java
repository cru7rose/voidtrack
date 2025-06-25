package com.voidtracker.oms.order.analytics;

import lombok.Data;

@Data
public class AnalyticsReportDto {
    private String reportId;
    private String type; // e.g., KPI, FLEET, ORDER
    private String generatedAt;
    private String generatedBy;
    private String content; // JSON or summary
}

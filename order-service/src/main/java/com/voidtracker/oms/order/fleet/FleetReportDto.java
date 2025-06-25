package com.voidtracker.oms.order.fleet;

import lombok.Data;

@Data
public class FleetReportDto {
    private String reportId;
    private String type; // e.g., VEHICLE, DRIVER, CARRIER
    private String generatedAt;
    private String generatedBy;
    private String content; // JSON or summary
}

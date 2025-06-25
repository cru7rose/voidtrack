package com.voidtracker.oms.order.mobile;

import lombok.Data;

@Data
public class DriverTaskDto {
    private String taskId;
    private String orderId;
    private String description;
    private String status;
    private String eta;
}

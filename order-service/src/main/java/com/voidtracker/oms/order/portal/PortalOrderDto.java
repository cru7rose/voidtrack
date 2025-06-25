package com.voidtracker.oms.order.portal;

import lombok.Data;

@Data
public class PortalOrderDto {
    private String orderId;
    private String status;
    private String customerName;
    private String deliveryEta;
    // Add more fields as needed for client portal
}

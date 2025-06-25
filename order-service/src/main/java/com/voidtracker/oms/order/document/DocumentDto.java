package com.voidtracker.oms.order.document;

import lombok.Data;

@Data
public class DocumentDto {
    private String id;
    private String orderId;
    private String type; // e.g., ePoD, invoice, etc.
    private String url;
    private String uploadedBy;
    private String uploadedAt;
}

package com.voidtracker.oms.order.billing;

import lombok.Data;

@Data
public class InvoiceDto {
    private String invoiceId;
    private String orderId;
    private double amount;
    private String currency;
    private String issuedAt;
    private String dueDate;
}

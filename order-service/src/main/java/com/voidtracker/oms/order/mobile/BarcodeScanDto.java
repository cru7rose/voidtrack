package com.voidtracker.oms.order.mobile;

import lombok.Data;

@Data
public class BarcodeScanDto {
    private String scanId;
    private String orderId;
    private String barcode;
    private String scannedBy;
    private String scannedAt;
}

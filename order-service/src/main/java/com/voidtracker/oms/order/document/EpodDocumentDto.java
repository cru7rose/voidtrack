package com.voidtracker.oms.order.document;

import lombok.Data;

@Data
public class EpodDocumentDto {
    private String documentId;
    private String orderId;
    private String epodId;
    private String url;
    private String uploadedBy;
    private String uploadedAt;
}

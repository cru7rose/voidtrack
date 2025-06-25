package com.voidtracker.oms.order.document;

import lombok.Data;

@Data
public class ComplianceCheckDto {
    private String checkId;
    private String documentId;
    private String type; // e.g., REGULATORY, CUSTOMS
    private boolean passed;
    private String checkedAt;
    private String checkedBy;
    private String notes;
}

package com.voidtracker.oms.order.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/documents/compliance")
public class ComplianceCheckController {
    @Autowired
    private ComplianceCheckService complianceCheckService;

    @GetMapping
    public List<ComplianceCheckDto> getAllComplianceChecks() {
        return complianceCheckService.getAllComplianceChecks();
    }
}

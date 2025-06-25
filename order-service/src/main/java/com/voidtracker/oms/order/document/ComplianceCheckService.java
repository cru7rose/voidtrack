package com.voidtracker.oms.order.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplianceCheckService {
    @Autowired
    private ComplianceCheckRepository complianceCheckRepository;

    public void saveComplianceCheck(ComplianceCheckDto check) {
        complianceCheckRepository.save(check);
    }

    public List<ComplianceCheckDto> getAllComplianceChecks() {
        return complianceCheckRepository.findAll();
    }
}

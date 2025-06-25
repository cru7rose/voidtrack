package com.voidtracker.oms.order.document;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ComplianceCheckRepository {
    private final Map<String, ComplianceCheckDto> checks = new HashMap<>();

    public void save(ComplianceCheckDto check) { checks.put(check.getCheckId(), check); }
    public Optional<ComplianceCheckDto> findById(String checkId) { return Optional.ofNullable(checks.get(checkId)); }
    public List<ComplianceCheckDto> findAll() { return new ArrayList<>(checks.values()); }
}

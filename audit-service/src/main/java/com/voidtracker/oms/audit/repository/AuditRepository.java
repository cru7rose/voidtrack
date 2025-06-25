package com.voidtracker.oms.audit.repository;

import com.voidtracker.oms.audit.dto.AuditDto;
import java.util.*;

public interface AuditRepository {
    List<AuditDto> findAll();
    Optional<AuditDto> findById(String auditId);
    AuditDto save(AuditDto event);

    void deleteById(String id);
}

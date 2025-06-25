package com.voidtracker.oms.order.mobile;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class BarcodeScanRepository {
    private final Map<String, BarcodeScanDto> scans = new HashMap<>();

    public void save(BarcodeScanDto scan) { scans.put(scan.getScanId(), scan); }
    public Optional<BarcodeScanDto> findById(String scanId) { return Optional.ofNullable(scans.get(scanId)); }
    public List<BarcodeScanDto> findAll() { return new ArrayList<>(scans.values()); }
}

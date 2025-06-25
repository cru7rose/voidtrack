package com.voidtracker.oms.order.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BarcodeScanService {
    @Autowired
    private BarcodeScanRepository barcodeScanRepository;

    public void saveScan(BarcodeScanDto scan) {
        barcodeScanRepository.save(scan);
    }

    public List<BarcodeScanDto> getAllScans() {
        return barcodeScanRepository.findAll();
    }
}

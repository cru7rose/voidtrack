package com.voidtracker.oms.order.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/mobile/barcode-scan")
public class BarcodeScanController {
    @Autowired
    private BarcodeScanService barcodeScanService;

    @GetMapping
    public List<BarcodeScanDto> getAllScans() {
        return barcodeScanService.getAllScans();
    }
}

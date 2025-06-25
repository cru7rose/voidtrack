package com.voidtracker.oms.order.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/mobile/epod")
public class EpodController {
    @Autowired
    private EpodService epodService;

    @GetMapping
    public List<EpodDto> getAllEpoods() {
        return epodService.getAllEpoods();
    }
}

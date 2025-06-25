package com.voidtracker.oms.order.tracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tracking")
public class TrackingController {
    @Autowired
    private TrackingService trackingService;

    // TODO: Implement endpoints for GPS event ingestion, real-time tracking, event streaming
}

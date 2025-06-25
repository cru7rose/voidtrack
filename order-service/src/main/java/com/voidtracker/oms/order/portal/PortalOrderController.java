package com.voidtracker.oms.order.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/portal/orders")
public class PortalOrderController {
    @Autowired
    private PortalOrderService portalOrderService;

    @GetMapping
    public List<PortalOrderDto> getAllOrders() {
        return portalOrderService.getAllOrders();
    }
}

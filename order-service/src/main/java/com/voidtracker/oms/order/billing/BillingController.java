package com.voidtracker.oms.order.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/billing")
public class BillingController {
    @Autowired
    private BillingServiceImpl billingService;

    @GetMapping("/invoices")
    public List<InvoiceDto> getAllInvoices() {
        return billingService.getAllInvoices();
    }
}

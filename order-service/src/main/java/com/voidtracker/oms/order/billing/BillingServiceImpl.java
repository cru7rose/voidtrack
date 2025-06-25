package com.voidtracker.oms.order.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BillingServiceImpl extends BillingService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    // TODO: Implement freight audit, cost calculation, invoicing, settlement logic
    public void saveInvoice(InvoiceDto invoice) {
        invoiceRepository.save(invoice);
    }

    public List<InvoiceDto> getAllInvoices() {
        return invoiceRepository.findAll();
    }
}

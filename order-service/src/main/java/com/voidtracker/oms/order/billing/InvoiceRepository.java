package com.voidtracker.oms.order.billing;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class InvoiceRepository {
    private final Map<String, InvoiceDto> invoices = new HashMap<>();

    public void save(InvoiceDto invoice) { invoices.put(invoice.getInvoiceId(), invoice); }
    public Optional<InvoiceDto> findById(String id) { return Optional.ofNullable(invoices.get(id)); }
    public List<InvoiceDto> findAll() { return new ArrayList<>(invoices.values()); }
}

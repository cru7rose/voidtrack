package com.voidtracker.oms.order.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderSearchCriteria {
    private String address;
    private String barcode;
    private String custId;
    private String alias;
    private int page;
    private int size;
}

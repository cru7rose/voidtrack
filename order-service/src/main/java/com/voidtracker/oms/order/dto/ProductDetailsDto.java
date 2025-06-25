package com.voidtracker.oms.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDetailsDto {
    private String productId;
    private String name;
    private String description;
    private Double weight;
    private Double volume;
    private Double price;
    private String currency;
}

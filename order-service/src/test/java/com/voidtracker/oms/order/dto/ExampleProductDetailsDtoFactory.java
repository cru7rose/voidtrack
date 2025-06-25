package com.voidtracker.oms.order.dto;

public class ExampleProductDetailsDtoFactory {
    public static ProductDetailsDto createExampleProductDetailsDto() {
        ProductDetailsDto product = new ProductDetailsDto();
        product.setProductId("prod-123");
        product.setName("Tarcza hamulcowa");
        product.setDescription("Tarcza hamulcowa do pojazdu ciężarowego");
        product.setWeight(12.5);
        product.setVolume(0.03);
        product.setPrice(250.00);
        product.setCurrency("PLN");
        return product;
    }
}

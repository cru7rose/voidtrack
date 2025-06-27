package com.voidtracker.oms.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        // Add this line to scan both the local 'order' package and the shared 'commons' package
        scanBasePackages = {"com.voidtracker.oms.order", "com.voidtracker.oms.commons"}
)
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
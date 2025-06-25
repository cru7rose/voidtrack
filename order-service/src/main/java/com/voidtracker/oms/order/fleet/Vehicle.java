package com.voidtracker.oms.order.fleet;

import lombok.Data;

@Data
public class Vehicle {
    private String id;
    private String registrationNumber;
    private String model;
    private String brand;
    private int year;
    private double capacity;
    // TODO: Add more fields as needed
}

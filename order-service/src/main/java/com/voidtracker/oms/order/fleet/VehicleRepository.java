package com.voidtracker.oms.order.fleet;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class VehicleRepository {
    private final Map<String, Vehicle> vehicles = new HashMap<>();

    public void save(Vehicle vehicle) { vehicles.put(vehicle.getId(), vehicle); }
    public Optional<Vehicle> findById(String id) { return Optional.ofNullable(vehicles.get(id)); }
    public List<Vehicle> findAll() { return new ArrayList<>(vehicles.values()); }
}

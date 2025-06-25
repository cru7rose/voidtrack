package com.voidtracker.oms.order.fleet;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class FleetRepository {
    private final Map<String, Vehicle> vehicles = new HashMap<>();
    private final Map<String, Driver> drivers = new HashMap<>();
    private final Map<String, Carrier> carriers = new HashMap<>();

    public void saveVehicle(Vehicle vehicle) { vehicles.put(vehicle.getId(), vehicle); }
    public Optional<Vehicle> findVehicleById(String id) { return Optional.ofNullable(vehicles.get(id)); }
    public List<Vehicle> findAllVehicles() { return new ArrayList<>(vehicles.values()); }

    public void saveDriver(Driver driver) { drivers.put(driver.getId(), driver); }
    public Optional<Driver> findDriverById(String id) { return Optional.ofNullable(drivers.get(id)); }
    public List<Driver> findAllDrivers() { return new ArrayList<>(drivers.values()); }

    public void saveCarrier(Carrier carrier) { carriers.put(carrier.getId(), carrier); }
    public Optional<Carrier> findCarrierById(String id) { return Optional.ofNullable(carriers.get(id)); }
    public List<Carrier> findAllCarriers() { return new ArrayList<>(carriers.values()); }
}

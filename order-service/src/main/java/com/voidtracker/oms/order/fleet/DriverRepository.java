package com.voidtracker.oms.order.fleet;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class DriverRepository {
    private final Map<String, Driver> drivers = new HashMap<>();

    public void save(Driver driver) { drivers.put(driver.getId(), driver); }
    public Optional<Driver> findById(String id) { return Optional.ofNullable(drivers.get(id)); }
    public List<Driver> findAll() { return new ArrayList<>(drivers.values()); }
}

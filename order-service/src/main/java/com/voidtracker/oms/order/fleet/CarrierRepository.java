package com.voidtracker.oms.order.fleet;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CarrierRepository {
    private final Map<String, Carrier> carriers = new HashMap<>();

    public void save(Carrier carrier) { carriers.put(carrier.getId(), carrier); }
    public Optional<Carrier> findById(String id) { return Optional.ofNullable(carriers.get(id)); }
    public List<Carrier> findAll() { return new ArrayList<>(carriers.values()); }
}

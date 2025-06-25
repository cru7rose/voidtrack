package com.voidtracker.oms.order.mobile;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EpodRepository {
    private final Map<String, EpodDto> epods = new HashMap<>();

    public void save(EpodDto epod) { epods.put(epod.getEpodId(), epod); }
    public Optional<EpodDto> findById(String epodId) { return Optional.ofNullable(epods.get(epodId)); }
    public List<EpodDto> findAll() { return new ArrayList<>(epods.values()); }
}

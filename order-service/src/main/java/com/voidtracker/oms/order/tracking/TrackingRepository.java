package com.voidtracker.oms.order.tracking;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class TrackingRepository {
    private final Map<String, TrackingEventDto> events = new HashMap<>();

    public void save(TrackingEventDto event) { events.put(event.getEventId(), event); }
    public Optional<TrackingEventDto> findById(String eventId) { return Optional.ofNullable(events.get(eventId)); }
    public List<TrackingEventDto> findAll() { return new ArrayList<>(events.values()); }
}

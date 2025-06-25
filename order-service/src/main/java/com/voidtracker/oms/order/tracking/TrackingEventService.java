package com.voidtracker.oms.order.tracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrackingEventService {
    @Autowired
    private TrackingEventRepository trackingEventRepository;

    public void saveEvent(TrackingEventDto event) {
        trackingEventRepository.save(event);
    }

    public List<TrackingEventDto> getAllEvents() {
        return trackingEventRepository.findAll();
    }
}

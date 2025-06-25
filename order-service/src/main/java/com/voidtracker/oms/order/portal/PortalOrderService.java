package com.voidtracker.oms.order.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortalOrderService extends PortalService {
    @Autowired
    private PortalOrderRepository portalOrderRepository;

    // TODO: Implement client self-service, order tracking, document download logic
    public List<PortalOrderDto> getAllOrders() {
        return portalOrderRepository.findAll();
    }
}

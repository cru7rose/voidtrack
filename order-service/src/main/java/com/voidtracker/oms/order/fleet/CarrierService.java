package com.voidtracker.oms.order.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarrierService {
    @Autowired
    private CarrierRepository carrierRepository;

    public void saveCarrier(Carrier carrier) {
        carrierRepository.save(carrier);
    }

    public List<Carrier> getAllCarriers() {
        return carrierRepository.findAll();
    }
}

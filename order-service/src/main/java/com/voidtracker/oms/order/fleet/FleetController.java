package com.voidtracker.oms.order.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fleet")
public class FleetController {
    @Autowired
    private FleetService fleetService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private CarrierService carrierService;

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/drivers")
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/carriers")
    public List<Carrier> getAllCarriers() {
        return carrierService.getAllCarriers();
    }
}

package com.voidtracker.oms.order.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @GetMapping
    public List<String> listVehicles() {
        // TODO: Return list of vehicles (DTO)
        return Collections.emptyList();
    }

    @GetMapping("/{vehicleId}")
    public String getVehicle(@PathVariable String vehicleId) {
        // TODO: Return vehicle details (DTO)
        return "";
    }

    @PostMapping
    public String createVehicle(@RequestBody String vehicleDto) {
        // TODO: Create new vehicle
        return "";
    }

    @PutMapping("/{vehicleId}")
    public String updateVehicle(@PathVariable String vehicleId, @RequestBody String vehicleDto) {
        // TODO: Update vehicle
        return "";
    }

    @DeleteMapping("/{vehicleId}")
    public void deleteVehicle(@PathVariable String vehicleId) {
        // TODO: Delete vehicle
    }
}

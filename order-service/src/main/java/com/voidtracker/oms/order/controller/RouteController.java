package com.voidtracker.oms.order.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
    @GetMapping
    public List<String> listRoutes() {
        // TODO: Return list of routes (DTO)
        return Collections.emptyList();
    }

    @GetMapping("/{routeId}")
    public String getRoute(@PathVariable String routeId) {
        // TODO: Return route details (DTO)
        return "";
    }

    @PostMapping
    public String createRoute(@RequestBody String routeDto) {
        // TODO: Create new route
        return "";
    }

    @PutMapping("/{routeId}")
    public String updateRoute(@PathVariable String routeId, @RequestBody String routeDto) {
        // TODO: Update route
        return "";
    }

    @DeleteMapping("/{routeId}")
    public void deleteRoute(@PathVariable String routeId) {
        // TODO: Delete route
    }
}

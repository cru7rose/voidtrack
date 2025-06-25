package com.voidtracker.oms.order.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/mobile/tasks")
public class DriverTaskController {
    @Autowired
    private DriverTaskService driverTaskService;

    @GetMapping
    public List<DriverTaskDto> getAllTasks() {
        return driverTaskService.getAllTasks();
    }
}

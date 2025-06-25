package com.voidtracker.oms.order.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverTaskService {
    @Autowired
    private DriverTaskRepository driverTaskRepository;

    public void saveTask(DriverTaskDto task) {
        driverTaskRepository.save(task);
    }

    public List<DriverTaskDto> getAllTasks() {
        return driverTaskRepository.findAll();
    }
}

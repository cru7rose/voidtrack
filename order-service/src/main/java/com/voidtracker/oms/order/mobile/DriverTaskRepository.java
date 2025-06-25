package com.voidtracker.oms.order.mobile;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class DriverTaskRepository {
    private final Map<String, DriverTaskDto> tasks = new HashMap<>();

    public void save(DriverTaskDto task) { tasks.put(task.getTaskId(), task); }
    public Optional<DriverTaskDto> findById(String taskId) { return Optional.ofNullable(tasks.get(taskId)); }
    public List<DriverTaskDto> findAll() { return new ArrayList<>(tasks.values()); }
}

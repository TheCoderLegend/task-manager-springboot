package com.vishnu.taskmanager.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vishnu.taskmanager.model.Task;
import com.vishnu.taskmanager.service.TaskService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task createTask(@RequestBody @Valid Task task) {
        return service.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }
    @GetMapping("/{id}")
public Task getTaskById(@PathVariable String id) {
    return service.getTaskById(id);
}
@PutMapping("/{id}")
public Task updateTask(@PathVariable String id, @RequestBody Task task) {
    return service.updateTask(id, task);
}
@DeleteMapping("/{id}")
public void deleteTask(@PathVariable String id) {
    service.deleteTask(id);
}

}
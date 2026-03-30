package com.vishnu.taskmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.vishnu.taskmanager.dto.ApiResponse;
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
    public ResponseEntity<ApiResponse<Task>> createTask(@RequestBody @Valid Task task) {

        Task createdTask = service.createTask(task);

        ApiResponse<Task> response = new ApiResponse<>(
                true,
                "Task created successfully",
                createdTask);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Task>>> getAllTasks() {

        List<Task> tasks = service.getAllTasks();

        ApiResponse<List<Task>> response = new ApiResponse<>(
                true,
                "Tasks fetched successfully",
                tasks);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> getTaskById(@PathVariable String id) {

        Task task = service.getTaskById(id);

        ApiResponse<Task> response = new ApiResponse<>(
                true,
                "Task fetched successfully",
                task);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> updateTask(@PathVariable String id, @RequestBody Task task) {

        Task updatedTask = service.updateTask(id, task);

        ApiResponse<Task> response = new ApiResponse<>(
                true,
                "Task updated successfully",
                updatedTask);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTask(@PathVariable String id) {

        service.deleteTask(id);

        ApiResponse<Void> response = new ApiResponse<>(
                true,
                "Task deleted successfully",
                null);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

}
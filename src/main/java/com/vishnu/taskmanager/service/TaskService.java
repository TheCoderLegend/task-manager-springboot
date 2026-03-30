package com.vishnu.taskmanager.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.vishnu.taskmanager.exception.ResourceNotFoundException;
import com.vishnu.taskmanager.model.Task;
import com.vishnu.taskmanager.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }
    public Task getTaskById(String id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
}

public Task updateTask(String id, Task updatedTask) {
    return repository.findById(id).map(task -> {
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());
        task.setUpdatedAt(LocalDateTime.now());
        return repository.save(task);
    }).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
}
public void deleteTask(String id) {
    repository.deleteById(id);
}

}
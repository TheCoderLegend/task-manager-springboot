package com.vishnu.taskmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.vishnu.taskmanager.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
}
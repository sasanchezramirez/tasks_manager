package com.task.taskManager.domain.gateway;

import com.task.taskManager.domain.models.Task;

import java.util.Optional;


public interface PersistenceGateway {
    Task createTask(Task task);
    Optional<Task> getTaskById(Integer id);
    Optional<Task> updateTask(Task task);
    Boolean deleteTask(Integer id);
}

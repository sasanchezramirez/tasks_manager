package com.task.taskManager.domain.gateway;

import com.task.taskManager.domain.models.Task;


public interface PersistenceGateway {
    Task createTask(Task task);
    Task getTaskById(Long id);
    Task updateTask(Task task, Long id);
    boolean deleteTask(Long id);
}

package com.task.taskManager.domain.infrastructure.drivenadapter.persistencia.service;

import com.task.taskManager.domain.gateway.PersistenceGateway;
import com.task.taskManager.domain.infrastructure.drivenadapter.persistencia.entities.TaskEntity;
import com.task.taskManager.domain.infrastructure.drivenadapter.persistencia.mappers.TaskMapper;
import com.task.taskManager.domain.infrastructure.drivenadapter.persistencia.repository.TaskRepository;
import com.task.taskManager.domain.models.Task;
import lombok.AllArgsConstructor;

import java.util.logging.Logger;

@AllArgsConstructor
public class PersistenceService implements PersistenceGateway {
    private static final Logger logger = Logger.getLogger(PersistenceService.class.getName());
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    @Override
    public Task createTask(Task task) {
        TaskEntity taskEntity = taskMapper.taskToTaskEntity(task);
        TaskEntity createdTaskEntity = taskRepository.createTask(taskEntity);
        return taskMapper.taskEntityToTask(createdTaskEntity);
    }

    @Override
    public Task getTaskById(Long id) {
        return null;
    }

    @Override
    public Task updateTask(Task task, Long id) {
        return null;
    }

    @Override
    public boolean deleteTask(Long id) {
        return false;
    }
}
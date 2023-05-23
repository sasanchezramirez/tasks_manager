package com.task.taskManager.domain.infrastructure.drivenadapter.persistencia.service;

import com.task.taskManager.domain.gateway.PersistenceGateway;
import com.task.taskManager.domain.infrastructure.drivenadapter.persistencia.entities.TaskEntity;
import com.task.taskManager.domain.infrastructure.drivenadapter.persistencia.mappers.TaskMapper;
import com.task.taskManager.domain.infrastructure.drivenadapter.persistencia.repository.TaskRepository;
import com.task.taskManager.domain.models.Task;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import java.util.logging.Logger;

@AllArgsConstructor
public class PersistenceService implements PersistenceGateway {
    private static final Logger logger = Logger.getLogger(PersistenceService.class.getName());
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    @Override
    public Task createTask(Task task) {
        logger.info("Petition was sent to create a task");
        TaskEntity taskEntity = taskMapper.taskToTaskEntity(task);
        TaskEntity createdTaskEntity = taskRepository.createTask(taskEntity);
        return taskMapper.taskEntityToTask(createdTaskEntity);
    }

    @Override
    public Optional<Task> getTaskById(Integer id) {
        logger.info("Petition was sent to get a task");
        return taskRepository.getTaskById(id)
                .map(this.taskMapper::taskEntityToTask);
    }

    @Override
    public Optional<Task> updateTask(Task task) {
        logger.info("Petition was sent to update a task");
        if (taskRepository.existsById(task.getId())){
            TaskEntity taskEntity = taskMapper.taskToTaskEntity(task);
            TaskEntity updatedTaskEntity = taskRepository.createTask(taskEntity);
            return Optional.ofNullable(taskMapper.taskEntityToTask(updatedTaskEntity));
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteTask(Integer id) {
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
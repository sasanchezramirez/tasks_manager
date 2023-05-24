package com.task.taskManager.infrastructure.persistencia.service;

import com.task.taskManager.domain.gateway.PersistenceGateway;
import com.task.taskManager.infrastructure.persistencia.mappers.TaskMapper;
import com.task.taskManager.infrastructure.persistencia.repository.TaskRepository;
import com.task.taskManager.infrastructure.persistencia.entities.TaskEntity;
import com.task.taskManager.domain.models.Task;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.logging.Logger;

@AllArgsConstructor
public class PersistenceService implements PersistenceGateway {
    private static final Logger logger = Logger.getLogger(PersistenceService.class.getName());
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final TaskEntity taskEntity;

    /**
     * @see PersistenceService#createTask(Task)
     */
    @Override
    public Task createTask(Task task) {
        logger.info("Petition was sent to create a task");
        this.taskMapper.taskToTaskEntity(task);
        TaskEntity createdTaskEntity = this.taskRepository.save(taskEntity);
        return this.taskMapper.taskEntityToTask(createdTaskEntity);
    }
    /**
     * @see PersistenceService#getTaskById(Integer)
     */
    @Override
    public Optional<Task> getTaskById(Integer id) {
        logger.info("Petition was sent to get a task");
        return this.taskRepository.findById(id)
                .map(this.taskMapper::taskEntityToTask);
    }
    /**
     * @see PersistenceService#updateTask(Task)
     */
    @Override
    public Optional<Task> updateTask(Task task) {
        logger.info("Petition was sent to update a task");
        if (this.taskRepository.existsById(task.getId())){
            TaskEntity taskEntity = this.taskMapper.taskToTaskEntity(task);
            TaskEntity updatedTaskEntity = this.taskRepository.save(taskEntity);
            return Optional.ofNullable(this.taskMapper.taskEntityToTask(updatedTaskEntity));
        }
        return Optional.empty();
    }
    /**
     * @see PersistenceService#deleteTask(Integer)
     */
    @Override
    public Boolean deleteTask(Integer id) {
        if (this.taskRepository.existsById(id)){
            this.taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
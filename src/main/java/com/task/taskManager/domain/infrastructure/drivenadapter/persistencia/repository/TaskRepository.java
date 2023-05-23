package com.task.taskManager.domain.infrastructure.drivenadapter.persistencia.repository;

import com.task.taskManager.domain.infrastructure.drivenadapter.persistencia.entities.TaskEntity;
import com.task.taskManager.domain.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    TaskEntity createTask(TaskEntity taskEntity);
    Optional<TaskEntity> getTaskById(Integer id);
    Optional<TaskEntity> updateTask(TaskEntity taskEntity);
}

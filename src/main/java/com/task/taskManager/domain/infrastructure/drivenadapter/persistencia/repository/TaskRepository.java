package com.task.taskManager.domain.infrastructure.drivenadapter.persistencia.repository;

import com.task.taskManager.domain.infrastructure.drivenadapter.persistencia.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    TaskEntity createTask(TaskEntity taskEntity);
}

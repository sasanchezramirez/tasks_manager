package com.task.taskManager.infrastructure.persistencia.repository;

import com.task.taskManager.infrastructure.persistencia.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}

package com.task.taskManager.domain.usecase;

import com.task.taskManager.domain.gateway.PersistenceGateway;
import com.task.taskManager.domain.models.Task;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UpdateTaskUseCase {
    private final PersistenceGateway persistenceGateway;
    public Optional<Task> updateTask(Task task){
        return persistenceGateway.updateTask(task);
    }
}

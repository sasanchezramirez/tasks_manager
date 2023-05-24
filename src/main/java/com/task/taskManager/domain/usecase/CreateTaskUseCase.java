package com.task.taskManager.domain.usecase;

import com.task.taskManager.domain.gateway.PersistenceGateway;
import com.task.taskManager.domain.models.Task;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTaskUseCase {
    private final PersistenceGateway persistenceGateway;
    public Task createTask(Task task){
        return persistenceGateway.createTask(task);
    }
}

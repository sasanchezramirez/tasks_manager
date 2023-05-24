package com.task.taskManager.domain.usecase;

import com.task.taskManager.domain.gateway.PersistenceGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteTaskUseCase {
    private final PersistenceGateway persistenceGateway;

    public String deleteTask(Integer id) {
        Boolean responseDelete = persistenceGateway.deleteTask(id);
        if (responseDelete) {
            return "Task eliminated";
        } else {
            return "Task was not eliminated";
        }
    }
}
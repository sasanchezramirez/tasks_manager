package com.task.taskManager.domain.usecase;

import com.task.taskManager.domain.gateway.PersistenceGateway;
import com.task.taskManager.domain.models.Task;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class GetTaskUseCase {
        private final PersistenceGateway persistenceGateway;
        public Optional<Task> getTaskById(Integer id){
            return persistenceGateway.getTaskById(id);
        }
}

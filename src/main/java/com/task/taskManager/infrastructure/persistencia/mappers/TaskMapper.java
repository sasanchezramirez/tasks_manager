package com.task.taskManager.infrastructure.persistencia.mappers;

import com.task.taskManager.infrastructure.persistencia.entities.TaskEntity;
import com.task.taskManager.domain.models.Task;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskMapper {
    public TaskEntity taskToTaskEntity(Task task){
        return new TaskEntity(task.getId(), task.getTitle(), task.getTitle(), task.getCompleted());
    }

    public Task taskEntityToTask(TaskEntity taskEntity){
        return new Task(taskEntity.getId(), taskEntity.getTitle(), taskEntity.getDescription(), taskEntity.getCompleted());
    }
}

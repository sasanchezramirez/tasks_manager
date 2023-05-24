package com.task.taskManager.infrastructure.persistencia.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("task")
public class TaskEntity {
    @Id
    private Integer id;
    private String title;
    private String description;
    private Boolean completed;

    public TaskEntity(Integer id, String title, String description, Boolean completed) {

    }
}

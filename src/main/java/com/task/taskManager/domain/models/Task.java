package com.task.taskManager.domain.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Task{
    @Id
    private Integer id;
    private String title;
    private String description;
    private Boolean completed;

    public Task(Integer id, String title, String description, Boolean completed) {
    }
}

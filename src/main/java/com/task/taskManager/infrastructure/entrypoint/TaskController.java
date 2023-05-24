package com.task.taskManager.infrastructure.entrypoint;

import com.task.taskManager.domain.models.Task;
import com.task.taskManager.infrastructure.persistencia.service.PersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
    private final PersistenceService persistenceService;
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return persistenceService.createTask(task);
    }
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Integer id){
        return persistenceService.getTaskById(id);
    }
    @PutMapping("/{id}")
    public Optional<Task> updateTask(@RequestBody Task task, @PathVariable Integer id) {
        return persistenceService.updateTask(task, id);
    }
    @DeleteMapping("/{id}")
    public Optional<Boolean> deleteTask(@PathVariable Integer id){
        return Optional.ofNullable(persistenceService.deleteTask(id));
    }
}

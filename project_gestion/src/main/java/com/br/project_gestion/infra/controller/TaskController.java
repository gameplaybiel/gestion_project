package com.br.project_gestion.infra.controller;

import com.br.project_gestion.application.dto.TaskDTO;
import com.br.project_gestion.application.mapper.TaskMapper;
import com.br.project_gestion.domain.model.Task;
import com.br.project_gestion.domain.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;
    private final TaskMapper mapper;

    public TaskController(TaskService service, TaskMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO){
        Task task = service.createTask(taskDTO.getName());
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        List<Task> tasks = service.getAllTask();
        List<TaskDTO> taskDTOs = tasks.stream().map(mapper::toDto).toList();
        return ResponseEntity.ok(taskDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id){
        Optional<Task> task = service.getTaskById(id);
        return task.map(value -> ResponseEntity.ok(mapper.toDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    public Task convertToEntity(TaskDTO taskDTO) {
        return new Task(null, taskDTO.getName(), false);
    }
}

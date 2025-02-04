package com.br.project_gestion.application.usecases;

import com.br.project_gestion.application.dto.TaskDTO;
import com.br.project_gestion.domain.model.Task;
import com.br.project_gestion.domain.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskUseCase {

    private final TaskService service;

    public TaskUseCase(TaskService service){
        this.service = service;
    }

    public TaskDTO createTask(String name){
        return toDTO(service.createTask(name));
    }

    private TaskDTO toDTO(Task task) {
        return new TaskDTO(task.getId(), task.getName(), task.isComplete());
    }

    public Optional<TaskDTO> getTaskById(Long id){
        return service.getTaskById(id).map(this::toDTO);
    }

    public void deleteTask(Long id){
        service.deleteTask(id);
    }
}

package com.br.project_gestion.application.mapper;

import com.br.project_gestion.application.dto.TaskDTO;
import com.br.project_gestion.domain.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task toEntity(TaskDTO taskDTO) {
        return new Task(null, taskDTO.getName(), false);
    }

    public TaskDTO toDto(Task task) {
        return new TaskDTO(task.getId(), task.getName(), task.isComplete());
    }
}

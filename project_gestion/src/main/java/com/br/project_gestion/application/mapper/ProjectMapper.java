package com.br.project_gestion.application.mapper;

import com.br.project_gestion.application.dto.ProjectDTO;
import com.br.project_gestion.domain.model.Project;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;

@Component
public class ProjectMapper {

    public Project toEntity(ProjectDTO projectDTO) {
        return new Project(
                projectDTO.getId(), // Pega o ID do DTO
                projectDTO.getName(),
                projectDTO.getDescription(),
                projectDTO.getStartDate() != null ? projectDTO.getStartDate() : LocalDate.now(), // Defina data de início se disponível
                projectDTO.getEndDate() != null ? projectDTO.getEndDate() : LocalDate.now().plusDays(30), // Defina data de fim se disponível
                Collections.emptyList() // Assumindo que a lista de tarefas é vazia inicialmente
        );
    }

    public ProjectDTO toDto(Project project){
        return new ProjectDTO(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate()
        );
    }
}

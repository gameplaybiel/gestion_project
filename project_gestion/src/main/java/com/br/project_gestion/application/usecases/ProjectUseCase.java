package com.br.project_gestion.application.usecases;

import com.br.project_gestion.application.dto.ProjectDTO;
import com.br.project_gestion.domain.model.Project;
import com.br.project_gestion.domain.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectUseCase {

    private final ProjectService service;

    public ProjectUseCase(ProjectService service){
        this.service = service;
    }

    public ProjectDTO createProject(Project project){
        return toDto(service.createProject(project));
    }

    private ProjectDTO toDto(Project project) {
        return new ProjectDTO(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate());
    }

    public List<ProjectDTO> getAllProjects(){
        return service.getAllProjects()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ProjectDTO> getProjectById(Long id){
        return service.getProjectById(id).map(this::toDto);
    }

    public void deleteProject(Long id){
        service.deleteProject(id);
    }
}

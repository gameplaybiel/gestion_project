package com.br.project_gestion.infra.controller;

import com.br.project_gestion.application.dto.ProjectDTO;
import com.br.project_gestion.application.mapper.ProjectMapper;
import com.br.project_gestion.domain.model.Project;
import com.br.project_gestion.domain.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService service;
    private final ProjectMapper mapper;

    public ProjectController(ProjectService service, ProjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO){
        Project project = mapper.toEntity(projectDTO);
        Project savedProject = service.createProject(project);
        ProjectDTO savedProjectDTO = mapper.toDto(savedProject);
        return new ResponseEntity<>(savedProjectDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects(){
        List<Project> projects = service.getAllProjects();
        List<ProjectDTO> projectDTOs = projects.stream().map(mapper::toDto).toList();
        return ResponseEntity.ok(projectDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id){
        Optional<Project> project = service.getProjectById(id);
        return project.map(value -> ResponseEntity.ok(mapper.toDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        service.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}

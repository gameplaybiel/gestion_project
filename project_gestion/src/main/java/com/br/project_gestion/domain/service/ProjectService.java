package com.br.project_gestion.domain.service;

import com.br.project_gestion.domain.model.Project;
import com.br.project_gestion.infra.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project createProject(Project project){
        return repository.save(project);
    }

    public List<Project> getAllProjects(){
        return repository.findAll();
    }

    public Optional<Project> getProjectById(Long id){
        return repository.findById(id);
    }

    public void deleteProject(Long id){
        repository.deleteById(id);
    }

}

package com.br.project_gestion;

import com.br.project_gestion.domain.model.Project;
import com.br.project_gestion.domain.service.ProjectService;
import com.br.project_gestion.infra.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {
    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    void shouldCreateProject() {
        Project project = new Project(1L, "Projeto Teste", "Descrição do projeto", LocalDate.now(), LocalDate.now().plusDays(10), new ArrayList<>());

        when(projectRepository.save(any(Project.class))).thenReturn(project);

        Project project1 = new Project(1L,"Projeto Teste", "Descrição do projeto", LocalDate.now(), LocalDate.now().plusDays(10), new ArrayList<>());
        Project result = projectService.createProject(project1);


        assertNotNull(result);
        assertEquals("Projeto Teste", result.getName());
    }
}

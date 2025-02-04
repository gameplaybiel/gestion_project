package com.br.project_gestion;

import com.br.project_gestion.domain.model.Task;
import com.br.project_gestion.domain.service.TaskService;
import com.br.project_gestion.infra.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void shouldReturnAllTasks() {

        Task task = new Task(1L, "Task Test", false);
        when(taskRepository.findAll()).thenReturn(List.of(task));

        List<Task> tasks = taskService.getAllTask();
        assertEquals(1, tasks.size());
        assertEquals("Task Test", tasks.get(0).getName());
    }
}

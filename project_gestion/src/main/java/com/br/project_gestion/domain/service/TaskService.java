package com.br.project_gestion.domain.service;

import com.br.project_gestion.domain.model.Task;
import com.br.project_gestion.infra.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(String name){
        Task task = new Task(null, name, false);
        return repository.save(task);
    }

    public List<Task> getAllTask(){
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return repository.findById(id);
    }

    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}

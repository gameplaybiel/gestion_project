package com.br.project_gestion.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean complete;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;


    public Task(Long id, String name, boolean complete) {
        this.id = id;
        this.name = name;
        this.complete = complete;
    }

    public Task(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

}

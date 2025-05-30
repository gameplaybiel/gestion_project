package com.br.project_gestion.application.dto;

public class TaskDTO {

    private Long id;
    private String name;
    private boolean complete;

    public TaskDTO(Long id, String name, boolean complete) {
        this.id = id;
        this.name = name;
        this.complete = complete;
    }

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

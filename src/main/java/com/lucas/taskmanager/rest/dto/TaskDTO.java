package com.lucas.taskmanager.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lucas.taskmanager.domain.model.Task;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDTO {
    private String title;
    private String description;
    private String status;
    private int priority;

    public TaskDTO(Task task) {
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.priority = task.getPriority();
    }
}

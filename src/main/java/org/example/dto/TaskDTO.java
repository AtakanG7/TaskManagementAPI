// src/main/java/org/example/dto/TaskDTO.java

package org.example.dto;

import java.time.LocalDateTime;

public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private String status;
    private Long assignedUserId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAssignedUserId(Long assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
}
package com.todolist.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class TaskDto {
    private String name;
    private String description;
    private Date time_create;
    private Date time_update;
}

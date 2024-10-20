package com.todolist.todolist.mappers;

import com.todolist.todolist.dto.TaskDto;
import com.todolist.todolist.models.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper implements EntityMapper<Task, TaskDto>{
    @Override
    public Task toEntity(TaskDto dto) {
        Task entity = new Task();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setTime_create(dto.getTime_create());
        entity.setTime_update(dto.getTime_update());
        return entity;
    }

    @Override
    public TaskDto toDto(Task entity) {
        TaskDto taskDto = new TaskDto();
        taskDto.setName(entity.getName());
        taskDto.setDescription(entity.getDescription());
        taskDto.setTime_create(entity.getTime_create());
        taskDto.setTime_update(entity.getTime_update());
        return taskDto;
    }
}

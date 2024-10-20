package com.todolist.todolist.services;

import com.todolist.todolist.dto.TaskDto;
import com.todolist.todolist.mappers.TaskMapper;
import com.todolist.todolist.models.Task;
import com.todolist.todolist.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServise {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;

    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream().map(task -> taskMapper.toDto(task)).collect(Collectors.toList());
    }

    public TaskDto getElementById(Integer id) {
        return taskRepository.findById(id).map(task -> taskMapper.toDto(task)).orElseThrow();
    }

    public void save(TaskDto taskDto) {
        taskDto.setTime_create(new Date());
        taskRepository.save(taskMapper.toEntity(taskDto));
    }

    public void update(Integer id, TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        task.setId(id);
        task.setTime_update(new Date());
        taskRepository.save(task);
    }

    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }
}

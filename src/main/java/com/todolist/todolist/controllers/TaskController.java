package com.todolist.todolist.controllers;

import com.todolist.todolist.dto.TaskDto;
import com.todolist.todolist.services.TaskServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskServise taskServise;

    @GetMapping()
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(taskServise.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(taskServise.getElementById(id));
    }

    @PostMapping()
    public ResponseEntity<?> saveNewTask(@RequestBody TaskDto taskDto) {
        taskServise.save(taskDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable("id") Integer id, @RequestBody TaskDto taskDto) {
        taskServise.update(id, taskDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Integer id) {
        taskServise.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

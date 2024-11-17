package com.apenasnagelo.api_rest.Controller;

import com.apenasnagelo.api_rest.Exception.TaskNotFoundException;
import com.apenasnagelo.api_rest.Exception.UnauthorizedAccessException;
import com.apenasnagelo.api_rest.Model.Task;
import com.apenasnagelo.api_rest.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository repository;

    private Integer getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Integer.parseInt(authentication.getName()); // Assuming the username is the userId
    }

    @GetMapping
    public List<Task> getTasks() {
        return repository.findByUserId(getCurrentUserId());
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable("id") Integer id) {
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        if (!task.getUserId().equals(getCurrentUserId())) {
            throw new UnauthorizedAccessException("Unauthorized access");
        }
        return task;
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        task.setUserId(getCurrentUserId());
        repository.save(task);
    }

    @PutMapping
    public void updateTask(@RequestBody Task task) {
        if (!task.getUserId().equals(getCurrentUserId())) {
            throw new UnauthorizedAccessException("Unauthorized access");
        }
        repository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Integer id) {
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        if (!task.getUserId().equals(getCurrentUserId())) {
            throw new UnauthorizedAccessException("Unauthorized access");
        }
        repository.deleteById(id);
    }
}
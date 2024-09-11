package com.lucas.taskmanager.rest.controller;

import com.lucas.taskmanager.domain.model.Task;
import com.lucas.taskmanager.rest.dto.TaskDTO;
import com.lucas.taskmanager.rest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TaskManager/")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO) {
        taskService.addTask(taskDTO);
        return new ResponseEntity<>(taskDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TaskDTO> deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO,
                                              @PathVariable Long id){
        return ResponseEntity.ok(taskService.editTask(taskDTO, id));
    }
}

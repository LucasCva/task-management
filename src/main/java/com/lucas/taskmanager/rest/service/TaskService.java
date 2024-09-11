package com.lucas.taskmanager.rest.service;

import com.lucas.taskmanager.domain.model.Task;
import com.lucas.taskmanager.domain.repository.TaskRepository;
import com.lucas.taskmanager.rest.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask (TaskDTO taskDTO) {
        Task newTask = new Task(taskDTO);
        taskRepository.save(newTask);
    }

    public TaskDTO getTask (long id) {
        Task task = taskRepository.getReferenceById(id);
        return new TaskDTO(task);
    }

    // TODO transforma a lista de task em uma lista de taskDTO
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream().map(TaskDTO::new).toList();
    }

    public void deleteTask (long id) {
        taskRepository.deleteById(id);
    }

    public TaskDTO editTask(TaskDTO taskDTO, long id) {
        Task task = taskRepository.getReferenceById(id);
        if (taskDTO.getTitle().isEmpty()) task.setTitle(taskDTO.getTitle());
        if (taskDTO.getDescription().isEmpty()) task.setDescription(taskDTO.getDescription());
        if (taskDTO.getStatus().isEmpty()) task.setStatus(taskDTO.getStatus());

        return new TaskDTO(taskRepository.save(task));
    }

}

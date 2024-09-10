package com.lucas.taskmanager.domain.repository;

import com.lucas.taskmanager.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

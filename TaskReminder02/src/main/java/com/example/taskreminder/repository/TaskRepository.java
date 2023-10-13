package com.example.taskreminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskreminder.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}

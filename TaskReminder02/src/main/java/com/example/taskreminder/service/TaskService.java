package com.example.taskreminder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskreminder.entity.Task;
import com.example.taskreminder.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Object getAllTasks() {
 		return taskRepository.findAll();
	}
	
	 public void addTask(Task task) {
	        taskRepository.save(task);
	    }

	    public void deleteTask(Long taskId) {
	        taskRepository.deleteById(taskId);
	    }

	    public void markTaskAsCompleted(Long taskId) {
	        Task task = taskRepository.findById(taskId).orElse(null);
	        if (task != null) {
	            task.setCompleted(true);
	            taskRepository.save(task);
	        }
	    }

	   public List<Task> getTasks() {
	        return taskRepository.findAll();
	    }


	    public void saveTask(Task task) {
	        taskRepository.save(task);
	    }
	
}

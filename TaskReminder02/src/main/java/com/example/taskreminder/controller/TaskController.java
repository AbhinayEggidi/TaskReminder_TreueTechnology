package com.example.taskreminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.taskreminder.entity.Task;
import com.example.taskreminder.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	 
	
	  @GetMapping("/")
	    public String displayTasks(Model model) {
	        model.addAttribute("tasks", taskService.getAllTasks());
	        return "list"; // Make sure the template name matches
	    }

	  @PostMapping("/addTask")
	    public String addTask(@ModelAttribute Task task) {
	        taskService.addTask(task);
	        return "redirect:/";
	    }

	    @GetMapping("/deleteTask/{id}")
	    public String deleteTask(@PathVariable Long id) {
	        taskService.deleteTask(id);
	        return "redirect:/";
	    }

	    @GetMapping("/markAsCompleted/{id}")
	    public String markTaskAsCompleted(@PathVariable Long id) {
	        taskService.markTaskAsCompleted(id);
	        return "redirect:/";
	    }
}

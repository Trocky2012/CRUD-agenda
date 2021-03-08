package com.stareng.agenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stareng.agenda.entities.Task;
import com.stareng.agenda.services.TaskService;

@RestController
@RequestMapping(value="/tasks")
public class TaskResources {
	
	@Autowired
	private TaskService service;
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll(){
		List <Task> taskList = service.findAll();
		return ResponseEntity.ok().body(taskList);
	}
	
	@PostMapping
	public ResponseEntity<Task> insert(@RequestBody Task task){
		task = service.insert(task);
		return ResponseEntity.ok().body(task);
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity <Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity <Task> update(@PathVariable Long id, @RequestBody Task task){
		task = service.update(id, task);
		return ResponseEntity.ok().body(task);
	}

}

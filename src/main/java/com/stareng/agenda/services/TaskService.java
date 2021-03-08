package com.stareng.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stareng.agenda.entities.Task;
import com.stareng.agenda.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	public List<Task> findAll() {
		return repository.findAll();
	}
	
	public Task insert(Task task) {
		return repository.save(task);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Task update(Long id, Task task) {
		Task entity = repository.getOne(id);
		entity.setTitle(task.getTitle());
		entity.setDate(task.getDate());
		return repository.save(entity);
	}

}

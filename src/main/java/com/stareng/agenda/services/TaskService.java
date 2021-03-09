package com.stareng.agenda.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	
	public List<Task> addMonth() throws ParseException{
		List<Task> list = repository.findAll();
		
		for(int i = 0; i < list.size() ; i++) {
			// New Date format, as used Task
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			// Get date from Task
			Date d = sdf.parse(list.get(i).getDate());
			// Create a Calendar
			Calendar cal = Calendar.getInstance();
			// Set Calendar with date that was got from Task
			cal.setTime(d);
			// Add one week
			cal.add(Calendar.MONTH, 1);
			// Save the new date in list
			list.get(i).setDate(sdf.format(cal.getTime()));
			//.Obj i of task list -> .setDate of task -> .parse to String on defined format -> .get Date from Calendar
		}
		return repository.saveAll(list);	
	}
	
	public List<Task> addWeek() throws ParseException{
		List<Task> list = repository.findAll();
		for(int i = 0; i < list.size() ; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date d = sdf.parse(list.get(i).getDate());
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.WEEK_OF_YEAR, 1);
			list.get(i).setDate(sdf.format(cal.getTime()));
		}
		return repository.saveAll(list);	
	}
	
	public List<Task> addDay() throws ParseException{
		List<Task> list = repository.findAll();
		for(int i = 0; i < list.size() ; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date d = sdf.parse(list.get(i).getDate());
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.DAY_OF_WEEK, 1);
			list.get(i).setDate(sdf.format(cal.getTime()));
		}
		return repository.saveAll(list);	
	}
}


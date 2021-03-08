package com.stareng.agenda.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.stareng.agenda.entities.Task;
import com.stareng.agenda.repositories.TaskRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public void run(String... args) throws Exception {
		Task t1 = new Task(null,"Lavar roupas.", new Date());
		Task t2 = new Task(null,"Programar app", new Date());
		taskRepository.saveAll(Arrays.asList(t1,t2));
	}

}

package com.stareng.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stareng.agenda.entities.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{

}

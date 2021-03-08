package com.stareng.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.stareng.agenda")
public class CrudAgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAgendaApplication.class, args);
	}

}

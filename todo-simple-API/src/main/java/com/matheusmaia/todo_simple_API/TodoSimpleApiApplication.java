package com.matheusmaia.todo_simple_API;

import org.flywaydb.core.FlywayExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoSimpleApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodoSimpleApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

package com.example.demo;

import com.example.demo.Todolist.TodoRepository;
import com.example.demo.Todolist.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SprinDataApplication implements CommandLineRunner {

	public SprinDataApplication(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SprinDataApplication.class, args);
	}

	@Autowired
	private final TodoRepository todoRepository;

	@Override
	public void run(String... args) throws Exception {
//		Todos todo = new Todos();
//		todo.setTask("work");
//		todoRepository.save(todo);
//
//
//		Todos todo1 = new Todos();
//		todo1.setTask("sleep");
//		todoRepository.save(todo1);
	}
}

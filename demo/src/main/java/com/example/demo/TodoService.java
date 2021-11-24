package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<TodoList> GetTodo() {
        return repository.findAll();
    }

    public TodoList GetTodo(String id) {
        Long Id = Long.parseLong(id);
        return repository.findById(Id).orElse(null);
    }

    public TodoList AddTodo(TodoList todo) {
        return repository.save(todo);
    }

    public String DeleteTodo(String id) {
        Long Id = Long.parseLong(id);
        repository.deleteById(Id);
        return "deleted";
    }

    public TodoList UpdateTodo(String id, TodoList todo) {
        Long Id = Long.parseLong(id);
        TodoList result = repository.findById(Id).orElse(null);
        if (result != null) {
            result.setName(todo.getName());
            repository.save(result);
        }
        return result;
    }
}



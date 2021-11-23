package com.example.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    private final TodoRepository repository;

    @Autowired
    public ToDoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<ToDo> GetTodo(){
        return repository.findAll();
    }

    public ToDo GetTodo(String id){
        Long Id = Long.parseLong(id);
        return repository.findById(Id).orElse(null);
    }

    public ToDo AddTodo(ToDo todo) {
        return repository.save(todo);
    }

    public String DeleteTodo(String id){
        Long Id = Long.parseLong(id);
        repository.deleteById(Id);
        return "deleted";
    }

    public ToDo UpdateTodo(String id, ToDo todo) {
        Long Id = Long.parseLong(id);
        ToDo result = repository.findById(Id).orElse(null);
        if (result != null){
            result.setName(todo.getName());
            repository.save(result);
        }
        return result;
    }

}

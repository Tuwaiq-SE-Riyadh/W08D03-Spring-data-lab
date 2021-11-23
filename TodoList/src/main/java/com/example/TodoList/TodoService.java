package com.example.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
//    AddTodo
//            GetTodo
//    UpdateTodo
//            DeleteTodo

    private final todoRepository repository;
    @Autowired
    public TodoService(todoRepository repository) {
        this.repository = repository;
    }


    private List<Todo> todos = new ArrayList<Todo>();

    //get all
    public List<Todo> GetTodos(){
        return repository.findAll();
    }
    public Todo GetTodo(int id){
        return repository.findById(id).orElse(null);
    }
    //add one to database
    public Todo AddTodo(Todo todo){
        return repository.save(todo);
    }

    public String UpdateTodo(int id, Todo data) {
        Todo todo= repository.findById(id).orElse(null);
        if(todo != null){
            todo.setName(data.getName());
            repository.save(todo);
        }

        return "updated";
    }
    public String DeleteTodo(int id) {
        repository.deleteById(id);
        return "deleted";
    }
}

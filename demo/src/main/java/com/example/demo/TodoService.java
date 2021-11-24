package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {
    private List<Todo> todos = new ArrayList<Todo>();
private final todoRepository todoRepository ;


    @Autowired
    public TodoService(todoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos(){

        return todoRepository.findAll();
    }

    public Todo addTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo getTodo(String id) {
        Long user_id = Long.parseLong(id);
        return todoRepository.findById(user_id).orElse(null);
    }

    public void deleteTodo(String id){
        Long user_id = Long.parseLong(id);
        todoRepository.deleteById(user_id);
    }

    public void updateTodo(String id, Todo data){
        Long todo_id = Long.parseLong(id);
        Todo todo = todoRepository.findById(todo_id).orElse(null);

        if (todo != null){
            todo.setName(data.getName());
            todoRepository.save(todo);
        }

    }

}

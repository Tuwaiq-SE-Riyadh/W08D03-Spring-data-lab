package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServes {

    @Autowired
    private  TodoRepository todoRepository;

    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo getTodo(String id){
    Long todoId =Long.parseLong(id);
        return todoRepository.findById(todoId).orElse(null);
    }

    public void deleteTodo(String id){
        Long deleteId = Long.parseLong(id);
        todoRepository.deleteById(deleteId);
    }

    public void updateTodo(String id, Todo data){
        Long updateTodo = Long.parseLong(id);
        Todo todo = todoRepository.findById(updateTodo).orElse(null);

        if(todo != null){
            todo.setName(data.getName());
            todoRepository.save(todo);
        }
    }
}

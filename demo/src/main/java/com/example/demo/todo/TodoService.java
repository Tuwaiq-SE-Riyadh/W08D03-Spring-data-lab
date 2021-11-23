package com.example.demo.todo;

import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {

        this.todoRepository = todoRepository;
    }


    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    public Todo getTodo(String id){
        int todo_id = Integer.valueOf(id);
        return todoRepository.findById(todo_id).orElse(null);
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public void deleteTodo(String id){
        int todo_id = Integer.valueOf(id);
        todoRepository.deleteById(todo_id);

    }

    public void updateTodo(String id, Todo data){
        System.out.println(id);
        int todo_id = Integer.valueOf(id);
        Todo todo = todoRepository.findById(todo_id).orElse(null);

        if (todo != null){
            todo.setName(data.getName());
            todoRepository.save(todo);
            }
        }

    }



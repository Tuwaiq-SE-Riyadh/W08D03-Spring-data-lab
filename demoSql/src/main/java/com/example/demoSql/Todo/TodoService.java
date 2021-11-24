package com.example.demoSql.Todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoService {


    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    public Todo getTodo(String id) {
        Long todo_id = Long.parseLong(id);
        return todoRepository.findById(todo_id).orElse(null);
    }

    public final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public Todo addTodo(Todo T) {
        return todoRepository.save(T);
    }

    public Todo update(String id, Todo data) {
        Long todo_id = Long.parseLong(id);
        Todo todo = todoRepository.findById(todo_id).orElse(null);

        if (todo != null) {
            todo.setName(data.getName());
            todoRepository.save(todo);
        }
        return todo;
    }


    public void deleteTodo(String id) {
        Long Todo_id = Long.parseLong(id);
        todoRepository.deleteById(Todo_id);
    }

}


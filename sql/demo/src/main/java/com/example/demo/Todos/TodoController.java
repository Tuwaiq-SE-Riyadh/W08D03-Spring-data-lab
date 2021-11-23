package com.example.demo.Todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "todos")

public class TodoController {


    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/{id}")
    public Todo getUser(@PathVariable String id) {
        return todoService.getTodo(id);

    }

    @PostMapping
    public Todo createUser(@RequestBody Todo user) {
        return todoService.createTodo(user);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);

    }

    @PutMapping("/{id}")
    public void updateTodo(@PathVariable String id, @RequestBody Todo data) {
        todoService.updateTodo(id, data);
    }
}



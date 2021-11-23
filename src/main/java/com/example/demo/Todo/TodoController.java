package com.example.demo.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="todo")
public class TodoController {

    private final TodoService TodoService;

    @Autowired
    public TodoController(TodoService TodoService) {
        this.TodoService = TodoService;
    }

    @GetMapping
    public List<Todo> getTodos(){
        return TodoService.getTodos();

    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable String id){
        return TodoService.getTodo(id);

    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo user){
        return TodoService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id){
        TodoService.deleteTodo(id);

    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody Todo data){
        TodoService.updateTodo(id, data);
    }
}

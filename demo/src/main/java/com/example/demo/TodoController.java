package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "todo")
public class TodoController {
    private final TodoService TodoService;

    @Autowired
    public TodoController(TodoService TodoService) {
        this.TodoService = TodoService;
    }
    @GetMapping
    public List<Todo> getTodo (@RequestParam(required = false) String filter){
        System.out.println(filter);
        return TodoService.getTodos();
    }


    @PostMapping
    public Todo addTodo(@RequestBody Todo todo){
        return TodoService.addTodo(todo);
    }


    @GetMapping("/{id}")
    public Todo getTodos(@PathVariable String id){
        return TodoService.getTodo(id);

    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id){
        TodoService.deleteTodo(id);
    }
    @PutMapping("/{id}")
    public void updateTodo(@PathVariable String id, @RequestBody Todo data){
        TodoService.updateTodo(id, data);
    }

}

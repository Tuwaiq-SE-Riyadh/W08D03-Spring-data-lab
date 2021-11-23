package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "todos")
public class TodoController {

    @Autowired
    private TodoServes todoServes;

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoServes.createTodo(todo);
    }

    @GetMapping
    public List<Todo> getTodos(){
        return todoServes.getTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable String id){
        return todoServes.getTodo(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id){
        todoServes.deleteTodo(id);
    }

    @PutMapping("/{id}")
    public void updateTodo(@PathVariable String id , @RequestBody Todo todo){
        todoServes.updateTodo(id, todo);
    }

}

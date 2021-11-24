package com.example.demo.ToDos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="todoList")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<Todo> getToDos(){
        return toDoService.getToDos();
    }

    @GetMapping("/{id}")
    public Todo getToDos(@PathVariable String id){
        return toDoService.getTodo(id);
    }

    @PostMapping
    public Todo createToDo(@RequestBody Todo todo){
        return toDoService.createTodo(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable String id){
        toDoService.deleteTodo(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody Todo todo){
        toDoService.updateToDo(id, todo);
    }
}

package com.example.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {this.toDoService = toDoService;}

    @GetMapping
    public List<ToDo> GetTodo(){
        return toDoService.GetTodo();
    }

    @GetMapping("/{id}")
    public ToDo GetTodo(@PathVariable String id ){
        return toDoService.GetTodo(id);
    }

    @PostMapping
    public ToDo addProduct(@RequestBody ToDo toDo){
        return toDoService.AddTodo(toDo);
    }

    @PutMapping("/{id}")
    public ToDo UpdateTodo(@PathVariable String id , @RequestBody ToDo toDo){
        return toDoService.UpdateTodo(id,toDo);
    }

    @DeleteMapping ("/{id}")
    public String deleteTodo(@PathVariable String id) {
        return toDoService.DeleteTodo(id);
    }
}

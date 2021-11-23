package com.example.springSQL.Todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="todolist")
public class TodolistController {

    private final TodolistService todolistService;

    @Autowired
    public TodolistController(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping
    public List<Todolist> getAllTodolist(){
        return todolistService.getAllTodo();
    }

    @PostMapping
    public Todolist creatTodolist(@RequestBody Todolist todolist){
        return todolistService.createTodolist(todolist);
    }

}

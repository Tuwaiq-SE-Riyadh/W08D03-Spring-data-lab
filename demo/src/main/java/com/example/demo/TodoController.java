package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="todos")

public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public List<TodoList> GetTodo(){
        return todoService.GetTodo();
    }

    @GetMapping("/{id}")
    public TodoList GetTodo(@PathVariable String id ){
        return todoService.GetTodo(id);
    }

    @PostMapping
    public TodoList addProduct(@RequestBody TodoList toDo){
        return todoService.AddTodo(toDo);
    }

    @PutMapping("/{id}")
    public TodoList UpdateTodo(@PathVariable String id , @RequestBody TodoList toDo){
        return todoService.UpdateTodo(id,toDo);
    }

    @DeleteMapping ("/{id}")
    public String deleteTodo(@PathVariable String id) {
        return todoService.DeleteTodo(id);
    }
}





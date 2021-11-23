package com.example.demo.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "todos")
public class Todocontroller {

    private final TodoService todoService;


    @Autowired
    public Todocontroller(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoList> getTodos(){
        return todoService.getTodos();
    }

    @PostMapping
    public TodoList addTodo(@RequestBody TodoList todo){
        return todoService.addTodo(todo);
    }

    @GetMapping("/{id}")
    public TodoList getTodo(@PathVariable String id){
        return todoService.getTodo(id);

    }
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id){
        todoService.deleteTodo(id);

    }

    @PutMapping("/{id}")
    public void updateTodo(@PathVariable String id, @RequestBody TodoList data){
        todoService.updateTodo(id, data);
    }
}

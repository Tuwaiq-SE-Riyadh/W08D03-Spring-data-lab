package com.example.demoSql.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "Todo")
public class TodoController {
    public final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable String id) {
        return todoService.getTodo(id);
    }
    @GetMapping
    public List<Todo> getAllTodo() {
        return todoService.getAllTodo();
    }
//

    @PostMapping
    public Todo addTodo(@RequestBody Todo T) {
        return todoService.addTodo(T);
    }

    @PutMapping("/{id}")
    public void updateTodo(@PathVariable String id,@RequestBody Todo T) {

         todoService.update(id,T);
    }
    @DeleteMapping
    public void deleteTodo(@PathVariable String id ) {

         todoService.deleteTodo(id);
    }
}

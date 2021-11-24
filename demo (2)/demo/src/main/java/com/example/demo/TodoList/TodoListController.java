package com.example.demo.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "todo")
public class TodoListController {

    private final TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService){this.todoListService = todoListService;}

    @GetMapping
    public List<TodoList> getTodos(){return todoListService.getTodos();}

    @GetMapping("/{id}")
    public TodoList getTodo(@PathVariable String id){return todoListService.getTodo(id);}

    @PostMapping
    public TodoList createTodo(@RequestBody TodoList todo){return todoListService.createTodo(todo);}

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id){todoListService.deleteTodo(id);}

    @PutMapping("/{id}")
    public void updateTodo(@PathVariable String id, @RequestBody TodoList data){todoListService.updateTodo(id, data);}
}

package com.example.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path= "todo")
public class Controller {

//    Get: to get all todos
//    Post: add new todo
//    Put: update todo
//    Delete: delete a todo list

    private final TodoService service;

    @Autowired
    public Controller(TodoService productService) {
        this.service = productService;
    }

    @GetMapping
    public List<Todo> getTodos(){
        return service.GetTodos();
    }
    @GetMapping(path = "/{id}")
    public Todo getTodo(@PathVariable int id){
        return service.GetTodo(id);
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo product){

        return service.AddTodo(product);
    }

    @PutMapping("/{id}")
    public String updateTodo(@PathVariable int id, @RequestBody Todo data){
        return service.UpdateTodo(id, data);
    }

    @DeleteMapping ("/{id}")
    public String deleteTodo(@PathVariable int id){
        return service.DeleteTodo(id);
    }
}

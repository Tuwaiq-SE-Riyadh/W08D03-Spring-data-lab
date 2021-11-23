package com.example.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "todo")
public class TodoController {
    private final TodoService todoservice;


    @Autowired
    public TodoController(TodoService todoservice) {
        this.todoservice = todoservice;
    }

    @GetMapping
    public List<Todo> getTodos(){
        System.out.println("kiiii");
        return todoservice.getTodos();
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo){
        return todoservice.addTodo(todo);
    }



//    not  found!!
    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable String id){
        return todoservice.getTodo(id);
    }





    @PutMapping("/{id}")
    public List<Todo> updateTodo(@PathVariable String id,@RequestBody Todo name){
        todoservice.updateTodo(id,name);
        return getTodos();

    }

    @DeleteMapping ("/{id}")
    public List<Todo> deletTodo(@PathVariable int id){
        todoservice.deletTodo(id);
        return getTodos();

    }


}

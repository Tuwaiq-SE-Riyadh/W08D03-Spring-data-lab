package com.example.demo.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//controller==> fetch request then pass to service
@RestController
@RequestMapping(path= "todo")
public class TodoController {
//to use service ==> private final TodoServies  todoServies ;
    //@Autowired meen need dependency injection

    private final TodoServies todoServies;
    @Autowired
    public TodoController(TodoServies todoServies) {
        this.todoServies=todoServies;
    }

    @GetMapping
    public  List<Todo> geTodos() {
        return todoServies.getTodos();
    }



    @GetMapping("/{id}")
//    pathvariable==>pass id or any thing to url
    public Todo getTodo(@PathVariable String id){
        return todoServies.getTodo(id);

    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoServies.createTodo(todo);
    }

//
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id){
        todoServies.deleteTodo(id);

    }
    @PutMapping("/{id}")
    public void updateTodo(@PathVariable String id, @RequestBody Todo data){
       todoServies.updateTodo(id, data);
   }
}

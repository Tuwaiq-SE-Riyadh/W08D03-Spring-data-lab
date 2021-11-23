package com.example.demo.todo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path= "todo")
public class TodoController {

    private final TodoService todoService;


    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }



    @GetMapping
    public List<Todo> getTodos(@RequestParam(required = false) String filter){
        System.out.println(filter);
        return todoService.getTodos();
    }

    @PostMapping
    public void addTodo(@RequestBody Todo todo){
         todoService.createTodo(todo);
    }



    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable String id){
        return todoService.getTodo(id);
    }

    @DeleteMapping("/{id}")
    public void delTodo(@PathVariable String id){
         todoService.deleteTodo(id);
    }

    @PutMapping("/{id}")
    public void updateTodo(@PathVariable String id, @RequestBody Todo data){
        todoService.updateTodo(id, data);
    }


}

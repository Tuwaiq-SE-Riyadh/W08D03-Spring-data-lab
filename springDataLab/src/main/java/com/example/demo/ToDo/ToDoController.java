package com.example.demo.ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path="users")
public class ToDoController {
    private final ToDoService ToDoService;

    @Autowired
    public ToDoController(ToDoService ToDoService) {
        this.ToDoService = ToDoService;
    }

    @GetMapping
    public List<ToDo> getToDo(){
        return ToDoService.getToDo();
    }

    @GetMapping("/{id}")
    public ToDo getToDos(@PathVariable String id){
        return ToDoService.getToDos(id);
    }

    @PostMapping
    public ToDo createToDo(@RequestBody ToDo todo){
        return ToDoService.createToDo(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable String id){
        ToDoService.deleteToDo(id);

    }

    @PutMapping("/{id}")
    public void updateToDo(@PathVariable String id, @RequestBody ToDo data){
        ToDoService.updateToDo(id, data);
    }
}

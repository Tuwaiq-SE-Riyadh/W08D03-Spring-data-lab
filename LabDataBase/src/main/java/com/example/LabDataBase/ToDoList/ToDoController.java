package com.example.LabDataBase.ToDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ToDo")
public class ToDoController {
    private final ToDoService toDoService;


    @Autowired
    public ToDoController(ToDoService toDoService) {this.toDoService = toDoService;}

    @GetMapping
    public List<ToDoList> getToDoList(){
        return toDoService.getToDo();
    }

    @GetMapping("/{id}")
    public ToDoList getTodo(@PathVariable String id){
        return toDoService.getToDo(id);
    }

    @PostMapping
    public ToDoList createToDo(@RequestBody ToDoList toDoList){return toDoService.createToDo(toDoList);}

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable String id){toDoService.deleteToDo(id);}

    @PutMapping("/{id}")
    public void updateToDo(@PathVariable String id, @RequestBody ToDoList data){toDoService.updateToDo(id, data);}
}

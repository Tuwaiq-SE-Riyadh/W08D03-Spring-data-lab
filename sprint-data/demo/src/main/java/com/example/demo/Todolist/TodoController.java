package com.example.demo.Todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Todos")
public class TodoController {



    @Autowired
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }



    @GetMapping
    public List<Todos> getTodos() {
        return todoRepository.findAll();
    }

    @PostMapping
    public Todos addTodo(@RequestBody Todos todo){
       return todoRepository.save(todo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Todos> updateTodo(@RequestBody Todos todo, @PathVariable int id){
        Todos newtodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        newtodo.setTask(todo.getTask());

        todoRepository.save(newtodo);
        return  ResponseEntity.ok(newtodo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Todos> deleteTodo(@PathVariable int id){
        Todos todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));


        todoRepository.delete(todo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}

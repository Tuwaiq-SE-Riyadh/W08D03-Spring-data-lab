package com.example.springSQL.Todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodolistService {

    private final TodolistRepository todolistRepository;

    @Autowired
    public TodolistService(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    public List<Todolist> getAllTodo(){
        return todolistRepository.findAll();
    }

    public Todolist createTodolist(Todolist todolist){
        return todolistRepository.save(todolist);
    }
}

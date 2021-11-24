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

    public Todolist getTodoById(String id){
        Long todo_id = Long.parseLong(id);
        return todolistRepository.findById(todo_id).orElse(null);
    }

    public Todolist createTodolist(Todolist todolist){
        return todolistRepository.save(todolist);
    }

    public void updateTodolist(String id,Todolist data){

        Long todo_id = Long.parseLong(id);
        Todolist todolist = todolistRepository.findById(todo_id).orElse(null);

        if(todolist != null){
            todolist.setName(data.getName());
            todolistRepository.save(todolist);
        }
    }

    public void deleteTodolist (String id){
        Long todo_id = Long.parseLong(id);
         todolistRepository.deleteById(todo_id);
    }
}

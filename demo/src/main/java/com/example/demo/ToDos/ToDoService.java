package com.example.demo.ToDos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    public List<Todo> getToDos(){
        return toDoRepository.findAll();
    }

    public Todo getUser(String id){
        Long user_id = Long.parseLong(id);
        return toDoRepository.findById(user_id).orElse(null);
    }

    public Todo createTodo(Todo todo){
        return toDoRepository.save(todo);
    }

    public void deleteTodo(String id){
        Long user_id = Long.parseLong(id);
        toDoRepository.deleteById(user_id);
    }

    public void updateToDo(String id, Todo data){
        Long ToDo_id = Long.parseLong(id);
        Todo todo = toDoRepository.findById(ToDo_id).orElse(null);
        if (todo != null){
            todo.setName(data.getName());
            toDoRepository.save(todo);
        }
    }
}

package com.example.demo.ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToDoService {
    private final ToDoRepository ToDoRepository;

    @Autowired
    public ToDoService(ToDoRepository ToDoRepository) {
        this.ToDoRepository = ToDoRepository;
    }


    public List<ToDo> getToDo(){
        return ToDoRepository.findAll();
    }

    public ToDo getToDos(String id){
        Long todo_id = Long.parseLong(id);
        return ToDoRepository.findById(todo_id).orElse(null);
    }

    public ToDo createToDo(ToDo Todo){
        return ToDoRepository.save(Todo);

    }

    public void deleteToDo(String id){
        Long todo_id = Long.parseLong(id);
        ToDoRepository.deleteById(todo_id);

    }

    public void updateToDo(String id, ToDo data){
        Long todo_id = Long.parseLong(id);
        ToDo todo = ToDoRepository.findById(todo_id).orElse(null);

        if (todo != null){
//            todo.setId(data.getId());
            todo.setName(data.getName());
            ToDoRepository.save(todo);
        }

    }

}

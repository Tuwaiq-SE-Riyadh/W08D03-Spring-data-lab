package com.example.LabDataBase.ToDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository ;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository){this.toDoRepository = toDoRepository;}

    public List<ToDoList> getToDo(){return toDoRepository.findAll();}

    public ToDoList getToDo(String id){
        Long toDo_id = Long.parseLong(id);
        return toDoRepository.findById(toDo_id).orElse(null);
    }

    public ToDoList createToDo(ToDoList toDo){
        return toDoRepository.save(toDo);
    }

    public void deleteToDo(String id){
        Long toDo_id = Long.parseLong(id);
        toDoRepository.deleteById(toDo_id);
    }

    public void updateToDo(String id , ToDoList data){
        Long toDo_id = Long.parseLong(id);
        ToDoList toDoList = toDoRepository.findById(toDo_id).orElse(null);

        if(toDoList != null){
            toDoList.setId(data.getId());
            toDoList.setToDo(data.getToDo());
            toDoRepository.save(toDoList);
        }

    }

}

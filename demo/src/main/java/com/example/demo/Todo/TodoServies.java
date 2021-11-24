package com.example.demo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//here busness logic====>service
//is java class+notaiton servvice
// any service is singletone
//dependeny injection
@Service
public class TodoServies {


    private final TodoRepository todoRepository;

    @Autowired
    public TodoServies (TodoRepository todoRepository) {
        this.todoRepository = todoRepository;

    }
//get all todo
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }
public Todo getTodo(String id){
    Integer todo_id = Integer.parseInt(id);
    return todoRepository.findById(todo_id).orElse(null);
}
//
    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);

    }
//
    public void deleteTodo(String id){
       Integer todo_id = Integer.parseInt(id);
        todoRepository.deleteById(todo_id);

    }
//
    public void updateTodo(String id, Todo data){
        Integer todo_id = Integer.parseInt(id);
        Todo todo = todoRepository.findById(todo_id).orElse(null);

        if (todo != null){
            todo.setName(data.getName());
            todoRepository.save(todo);
        }
//
//    }
//
}
}


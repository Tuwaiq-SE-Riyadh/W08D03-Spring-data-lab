package com.example.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {


    private List<Todo> Todos = new ArrayList<Todo>();


    private final todoRepository todorepository;
    @Autowired
    public TodoService(todoRepository todorepository) {
        this.todorepository=todorepository;
    }

    public List<Todo> getTodos(){

        return  todorepository.findAll();
    }

    public Todo getTodo(String id){
        int user_id = Integer.parseInt(id);
        return todorepository.findById(user_id).orElse(null);
    }

    public Todo addTodo(Todo todo){

        return todorepository.save(todo);
    }


    public void updateTodo(String id, Todo name) {

        int user_id = Integer.parseInt(id);
        Todo todo = todorepository.findById(user_id).orElse(null);

        if (todo != null){
            todo.setName(name.getName());
            todorepository.save(todo);
        }



    }


    public void deletTodo(int id){

         todorepository.deleteById(id);
    }
}

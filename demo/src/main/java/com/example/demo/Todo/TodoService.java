package com.example.demo.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public List<Todo> getTodo(){
        return todoRepository.findAll();
    }

    public Todo getTodo(String id){
        Long todo_id = Long.parseLong(id);
        return todoRepository.findById(todo_id).orElse(null);
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public void deleteTodo(String id){
        Long todo_id = Long.parseLong(id);
        todoRepository.deleteById(todo_id);

    }

    public void updateTodo(String id, Todo data){
        Long todo_id = Long.parseLong(id);
        Todo todo = todoRepository.findById(todo_id).orElse(null);

        if (todo != null){
            todo.setName(data.getName());
            todoRepository.save(todo);
        }

    }

}

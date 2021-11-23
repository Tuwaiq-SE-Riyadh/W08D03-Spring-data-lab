package com.example.demo.Todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//use service to do business logic to handle database
@Service
public class TodoService {


    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;

    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodo(String id) {
        Long user_id = Long.parseLong(id);
        return todoRepository.findById(user_id).orElse(null);
    }

    public Todo createTodo(Todo user) {

        return todoRepository.save(user);
    }

    public void deleteTodo(String id) {
        Long user_id = Long.parseLong(id);
        todoRepository.deleteById(user_id);
    }

    public void updateTodo(String id, Todo data) {
        Long user_id = Long.parseLong(id);
        Todo user = todoRepository.findById(user_id).orElse(null);
        if (data != null)
            user.setName(data.getName());
        user.setEmail(data.getEmail());
        todoRepository.save(data);
    }


}

package com.example.demo.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoListService(TodoListRepository todoListRepository){this.todoListRepository = todoListRepository;}

    public List<TodoList> getTodos(){return todoListRepository.findAll();}

    public TodoList getTodo(String id){
        Long todo_id = Long.parseLong(id);
        return todoListRepository.findById(todo_id).orElse(null);
    }

    public TodoList createTodo(TodoList todo){
        return todoListRepository.save(todo);
    }

    public void deleteTodo(String id){
        Long todo_id = Long.parseLong(id);
        todoListRepository.deleteById(todo_id);
    }

    public void updateTodo(String id, TodoList data){
        Long todo_id = Long.parseLong(id);
        TodoList todo = todoListRepository.findById(todo_id).orElse(null);

        if(todo != null){
            todo.setName(data.getName());
            todoListRepository.save(todo);
        }
    }
}

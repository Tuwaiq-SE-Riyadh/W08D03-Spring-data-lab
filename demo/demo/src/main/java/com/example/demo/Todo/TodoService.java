package com.example.demo.Todo;
import com.example.demo.Todo.TodoList;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoList> getTodos(){

        return todoRepository.findAll();
    }

    public TodoList addTodo(TodoList todo){
        return todoRepository.save(todo);
    }

    public TodoList getTodo(String id) {

        Long todoId = Long.parseLong(id);
        return todoRepository.findById(todoId).orElse(null);
    }

    public void deleteTodo(String id){
        Long todoId = Long.parseLong(id);
        todoRepository.deleteById(todoId);

    }

    public void updateTodo(String id, TodoList data){
        Long todoId = Long.parseLong(id);
        TodoList todo = todoRepository.findById(todoId).orElse(null);

        if (todo != null){
            todo.setId((int) data.getId());
            todo.setName(data.getName());
            todoRepository.save(todo);
        }

    }
}

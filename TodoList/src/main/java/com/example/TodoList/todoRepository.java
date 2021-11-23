package com.example.TodoList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface todoRepository extends JpaRepository<Todo, Integer> {
}

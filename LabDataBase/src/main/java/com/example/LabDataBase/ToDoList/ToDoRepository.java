package com.example.LabDataBase.ToDoList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoList,Long> {
}

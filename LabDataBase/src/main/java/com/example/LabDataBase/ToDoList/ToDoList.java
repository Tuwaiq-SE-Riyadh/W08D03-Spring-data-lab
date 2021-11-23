package com.example.LabDataBase.ToDoList;


import javax.persistence.*;

@Entity
@Table(name = "List")
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ToDo;

    public ToDoList(long id, String toDo) {
        this.id = id;
        ToDo = toDo;
    }

    public ToDoList() {}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getToDo() {return ToDo;}

    public void setToDo(String toDo) {ToDo = toDo;}



    @Override
    public String toString() {
        return "ToDoList{" +
                "id=" + id +
                ", ToDo='" + ToDo + '\'' +
                '}';
    }
}

package com.example.taskmanagementsystem;

public class Employees {
    private Integer id_P;
    private String name;
    private String surname;
    private String post;

    public Employees(Integer id_P, String surname, String name, String post) {
        this.id_P=id_P;
        this.surname=surname;
        this.name = name;
        this.post = post;
    }

    public Integer getId() {
        return id_P;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

}

package com.example.taskmanagementsystem.AdapterAndClass;

public class Employees {
    private String id_P;
    private String name;
    private String surname;
    private String post;

    public Employees(String id_P, String surname, String name, String post) {
        this.id_P=id_P;
        this.surname = surname;
        this.name = name;
        this.post = post;
    }

    public String getId() {
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

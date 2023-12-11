package com.example.taskmanagementsystem.AdapterAndClass;

public class Tasks {

    private String id_T;
    private String Tname;

    public Tasks(String id_T, String Tname) {
        this.id_T=id_T;
        this.Tname = Tname;
    }

    public String getId() {
        return id_T;
    }

    public String getName() {
        return Tname;
    }

}

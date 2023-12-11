package com.example.taskmanagementsystem;

public class SecondTask {
    private String id_ST;
    private String STname;

    private String SCheck;

    public SecondTask(String id_ST, String STname, String SCheck) {
        this.id_ST=id_ST;
        this.STname = STname;
        this.SCheck = SCheck;
    }


    public String getIdTask() {
        return id_ST;
    }

    public String getNameTask() {
        return STname;
    }
    public String getCheck() {
        return SCheck;
    }
}


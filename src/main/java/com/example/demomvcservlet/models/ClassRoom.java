package com.example.demomvcservlet.models;

public class ClassRoom {
    private int id_class;
    private String name;

    public ClassRoom(int id_class, String name) {
        this.id_class = id_class;
        this.name = name;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

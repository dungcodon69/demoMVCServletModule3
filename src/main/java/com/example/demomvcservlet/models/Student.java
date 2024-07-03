package com.example.demomvcservlet.models;

public class Student {

    private Long id;
    private String name;
    private String address;
    private Float point;
    private int id_class;

    public Student() {
    }

    public Student(Long id, String name, String address, Float point) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.point = point;
    }

    public Student(String name, String address, Float point, int id_class) {
        this.name = name;
        this.address = address;
        this.point = point;
        this.id_class = id_class;
    }

    public Student(Long id, String name, String address, Float point, int id_class) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.point = point;
        this.id_class = id_class;
    }

    public Student(String name, String address, Float point) {
        this.name = name;
        this.address = address;
        this.point = point;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }
}

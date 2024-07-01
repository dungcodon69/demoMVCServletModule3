package com.example.demomvcservlet.services;

import com.example.demomvcservlet.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    Student findById(long id);

    void updateById(long id, Student student1);

    void deleteById(long idDelete);

    List<Student> searchByName(String searchName);
}

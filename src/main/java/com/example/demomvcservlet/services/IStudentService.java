package com.example.demomvcservlet.services;

import com.example.demomvcservlet.dto.StudentDTO;
import com.example.demomvcservlet.models.Student;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> findAll();

    void save(Student student);


    void updateById(long id, Student student1);

    void deleteById(long idDelete);

    List<StudentDTO> searchByName(String searchName);

    Student findById(long id);
}

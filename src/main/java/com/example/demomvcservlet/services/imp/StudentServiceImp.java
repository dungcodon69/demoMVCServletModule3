package com.example.demomvcservlet.services.imp;

import com.example.demomvcservlet.dto.StudentDTO;
import com.example.demomvcservlet.models.Student;
import com.example.demomvcservlet.repositories.StudentRepository;
import com.example.demomvcservlet.services.IStudentService;

import java.util.List;

public class StudentServiceImp implements IStudentService {
    StudentRepository studentRepository = new StudentRepository();
    @Override
    public List<StudentDTO> findAll(){
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.add(student);
    }


    @Override
    public void updateById(long id, Student student1) {
        studentRepository.updateById(id,student1);
    }

    @Override
    public void deleteById(long idDelete) {
        studentRepository.deleteById(idDelete);
    }

    @Override
    public List<StudentDTO> searchByName(String searchName) {
        return studentRepository.searchByName(searchName);
    }

    @Override
    public Student findById(long id) {
        return studentRepository.findById(id);
    }
}

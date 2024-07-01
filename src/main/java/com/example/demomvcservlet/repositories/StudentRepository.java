package com.example.demomvcservlet.repositories;

import com.example.demomvcservlet.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static List<Student> students = new ArrayList<>();
    static {
        students = new ArrayList<>();
        students.add(new Student(1L,"haiTT", "QN", 10.0f));
        students.add(new Student(2L,"Bảo Ngọc", "HN", 8.0f));
        students.add(new Student(3L,"Bảo Kỳ", "DN", 6.0f));
        students.add(new Student(5L,"Cook", "Bàn ăn", 2f));
    }

    public List<Student> findAll(){
        return new ArrayList<>(students);
    }

    public void add(Student student) {
        long id = getLastID();
        student.setId(id+1);
        students.add(student);
    }

    private long getLastID() {
        if (students.isEmpty()){
            return 1;
        }
        return students.get(students.size()-1).getId();
    }

    public Student findById(long id) {
        for (Student s : students){
            if (s.getId() == id) return s;
        }
        return null;
    }

    public void updateById(long id, Student student1) {
        Student s = findById(id);
        s.setName(student1.getName());
        s.setAddress(student1.getAddress());
        s.setPoint(student1.getPoint());
    }

    public void deleteById(long idDelete) {
        Student s = findById(idDelete);
        students.remove(s);
    }

    public List<Student> searchByName(String searchName) {
        List<Student> students1 = new ArrayList<>();
        for (Student s : students){
            if (s.getName().contains(searchName)){
                students1.add(s);
            }
        }
        return students1;
    }
}

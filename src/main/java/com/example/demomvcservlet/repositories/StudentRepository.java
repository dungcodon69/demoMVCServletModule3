package com.example.demomvcservlet.repositories;

import com.example.demomvcservlet.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/jdbcdemo?useSSL=false";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "codegym";
    private static final Connection connection;
    private static final String SELECT_ALL_STUDENT = "SELECT * FROM student";
    private static final String SEARCH_STUDENT_BY_NAME = "SELECT * FROM student WHERE name LIKE CONCAT('%',?,'%')";
    private static final String ADD_NEW_STUDENT = "INSERT INTO student(name,address,point) values(?,?,?)";
    private static final String DELETE_STUDENT_BY_ID = "DELETE FROM student WHERE id = ?";
    private static final String FIND_STUDENT_BY_ID = "SELECT * FROM student WHERE id = ?";
    private static final String UPDATE_STUDENT_BY_ID = "UPDATE student SET name=?,address=?,point=? WHERE id = ?";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Student> findAll(){
        List<Student> students1 = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet set = statement.executeQuery(SELECT_ALL_STUDENT)){
            students1 = getStudentFromResultSet(set);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students1;
    }

    public void add(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_STUDENT);){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getAddress());
            preparedStatement.setFloat(3,student.getPoint());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void updateById(long id, Student student1) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_BY_ID);){
            preparedStatement.setString(1,student1.getName());
            preparedStatement.setString(2,student1.getAddress());
            preparedStatement.setFloat(3,student1.getPoint());
            preparedStatement.setLong(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(long idDelete) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_BY_ID);){
            preparedStatement.setLong(1,idDelete);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Student> searchByName(String searchName) {
        List<Student> students1 = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENT_BY_NAME);){
            preparedStatement.setString(1,searchName);
            ResultSet set = preparedStatement.executeQuery();
            students1 = getStudentFromResultSet(set);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students1;
    }

    private List<Student> getStudentFromResultSet(ResultSet set) throws SQLException {
        List<Student> students1 = new ArrayList<>();
        while (set.next()){
            long id = set.getLong("id");
            String name = set.getString("name");
            String address = set.getString("address");
            float point = set.getFloat("point");
            Student student = new Student(id,name,address,point);
            students1.add(student);
        }
        return students1;
    }

    public Student findById(long id) {
        Student s = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_STUDENT_BY_ID);){
            preparedStatement.setLong(1,id);
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()){
                s = new Student(set.getLong("id"),set.getString("name"),set.getString("address"),set.getFloat("point"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }
}

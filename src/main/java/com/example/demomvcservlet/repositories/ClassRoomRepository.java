package com.example.demomvcservlet.repositories;

import com.example.demomvcservlet.models.ClassRoom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomRepository {
    private static final String SELECT_ALL_CLASSROOM = "select * from classroom";

    public List<ClassRoom> findAll() {
        List<ClassRoom> classRooms = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = DBConnection.getConnectionInstance().prepareStatement(SELECT_ALL_CLASSROOM);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                int id = set.getInt("id_class");
                String name = set.getString("name");
                ClassRoom classRoom = new ClassRoom(id,name);
                classRooms.add(classRoom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classRooms;
    }
}

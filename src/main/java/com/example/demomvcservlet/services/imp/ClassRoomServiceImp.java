package com.example.demomvcservlet.services.imp;

import com.example.demomvcservlet.models.ClassRoom;
import com.example.demomvcservlet.repositories.ClassRoomRepository;
import com.example.demomvcservlet.services.IClassRoomService;

import java.util.List;

public class ClassRoomServiceImp implements IClassRoomService {
    ClassRoomRepository classRoomRepository = new ClassRoomRepository();
    @Override
    public List<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }
}

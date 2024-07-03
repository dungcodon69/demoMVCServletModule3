package com.example.demomvcservlet.services;

import com.example.demomvcservlet.models.ClassRoom;

import java.util.List;

public interface IClassRoomService {
    List<ClassRoom> findAll();
}

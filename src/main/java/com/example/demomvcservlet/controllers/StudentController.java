package com.example.demomvcservlet.controllers;



import com.example.demomvcservlet.dto.StudentDTO;
import com.example.demomvcservlet.models.ClassRoom;
import com.example.demomvcservlet.models.Student;
import com.example.demomvcservlet.services.IClassRoomService;
import com.example.demomvcservlet.services.IStudentService;
import com.example.demomvcservlet.services.imp.ClassRoomServiceImp;
import com.example.demomvcservlet.services.imp.StudentServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {

    private static IStudentService studentService = new StudentServiceImp();
    private static IClassRoomService classRoomService = new ClassRoomServiceImp();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                System.out.println("Create");
                List<ClassRoom> classRooms = classRoomService.findAll();
                req.setAttribute("classroom", classRooms);
                req.getRequestDispatcher("/student/create.jsp").forward(req,resp);
                break;
            case "update":
                long id = Long.parseLong(req.getParameter("id"));
                Student student = studentService.findById(id);
                List<ClassRoom> classRooms1 = classRoomService.findAll();
                if (student != null){
                    req.setAttribute("student",student);
                    req.setAttribute("classroom",classRooms1);
                    req.getRequestDispatcher("/student/update.jsp").forward(req,resp);
                } else {
                    req.getRequestDispatcher("/error.jsp").forward(req,resp);
                }
                break;
//
            default:
                List<StudentDTO> students = studentService.findAll();
                req.setAttribute("students", students);
                req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                String name = req.getParameter("name");
                String address = req.getParameter("address");
                Float point = Float.valueOf(req.getParameter("point"));
                int id_class = Integer.parseInt(req.getParameter("classroom"));
                Student student = new Student(name,address,point,id_class);
                studentService.save(student);
                resp.sendRedirect("/student");
                break;
            case "update":
                long id = Long.parseLong(req.getParameter("id"));
                String nameUpdate = req.getParameter("name");
                String addressUpdate = req.getParameter("address");
                float pointUpdate = Float.parseFloat(req.getParameter("point"));
                int idClassUpdate = Integer.parseInt(req.getParameter("classroom"));
                Student student1 = new Student(nameUpdate,addressUpdate,pointUpdate,idClassUpdate);
                studentService.updateById(id,student1);
                resp.sendRedirect("/student");
                break;
            case "delete":
                long idDelete = Long.parseLong(req.getParameter("id"));
                    studentService.deleteById(idDelete);
                    resp.sendRedirect("/student");
                    //req.getRequestDispatcher("/error.jsp").forward(req,resp);
                break;
            case "search":
                String searchName = req.getParameter("searchName");
                List<StudentDTO> studentsSearch = studentService.searchByName(searchName);
                req.setAttribute("students", studentsSearch);
                req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
                break;
        }
    }
}

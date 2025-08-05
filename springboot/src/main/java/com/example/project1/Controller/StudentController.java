package com.example.project1.Controller;


import com.example.project1.Service.StudentService;
import com.example.project1.model.Result;
import com.example.project1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    // get method for student
    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return service.getAllStudent();
    }

    //get student by id
    @GetMapping("/student/{Id}")
    public Student getStudentById(@PathVariable int Id){
        return service.getStudentById(Id);
    }

    //post student
    @PostMapping("/student")
    public void addStudent(@RequestBody Student student){
        System.out.println(student);
        service.addStudent(student);
    }

    //put student
    @PutMapping("/student/{Id}")
    public void updateStudent(@PathVariable Integer Id, @RequestBody Student student){
        service.updateStudent(Id, student);
    }

    //delete student
    @DeleteMapping("/student/{Id}")
    public void deleteStudent(@PathVariable int Id){
        service.deleteStudent(Id);
    }
}

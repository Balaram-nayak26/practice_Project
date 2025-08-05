package com.example.project1.Controller;


import com.example.project1.Service.CourseService;
import com.example.project1.model.Course;
import com.example.project1.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService service;

    //get all courses
    @GetMapping("/course")
    public List<Course> getAllCourse(){
        return service.getAllCourse();
    }

    //get courses by id
    @GetMapping("/course/{Id}")
    public Course getCourseById(@PathVariable int Id){
        return service.getCourseById(Id);
    }

    //Post method for course
    @PostMapping("/course")
    public void addCourse(@RequestBody Course course){
        System.out.println(course);
        service.addCourse(course);
    }

    //Put method for course
    @PutMapping("course/{Id}")
    public void updateCourse(@PathVariable Integer id, @RequestBody Course course){
        service.updateCourse(id, course);
    }

    //Delete method for courses
    @DeleteMapping("/course/{Id}")
    public void deleteCourse(@PathVariable int Id){
        service.deleteCourse(Id);
    }
}

package com.example.project1.Controller;


import com.example.project1.Service.CourseEnrollmentService;
import com.example.project1.model.CourseEnrollment;
import com.example.project1.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseEnrollmentController {

    @Autowired
    private CourseEnrollmentService service;

    //get all course_enrollment
    @GetMapping("/course_enrollment")
    public List<CourseEnrollment> getAllCourseEnrollment(){
        return service.getAllCourseEnrollment();
    }

    //get course_enrollment by id
    @GetMapping("/course_enrollment/{Id}")
    public CourseEnrollment getCourseEnrollmentById(@PathVariable int Id){
        return service.getCourseEnrollmentById(Id);
    }

    //Post method for course_enrollment
    @PostMapping("/course_enrollment")
    public void addCourseEnrollment(@RequestBody CourseEnrollment course_enrollment){
        System.out.println(course_enrollment);
        service.addCourseEnrollment(course_enrollment);
    }

    //Put method for course_enrollment
    @PutMapping("course_enrollment/{Id}")
    public void updateCourseEnrollment(@PathVariable Integer id, @RequestBody CourseEnrollment course_enrollment){
        service.updateCourseEnrollment(id, course_enrollment);
    }

    //Delete method for course_enrollment
    @DeleteMapping("/course_enrollment/{Id}")
    public void deleteCourseEnrollment(@PathVariable int Id){
        service.deleteCourseEnrollment(Id);
    }
}

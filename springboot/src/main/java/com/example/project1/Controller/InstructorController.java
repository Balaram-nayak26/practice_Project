package com.example.project1.Controller;



import com.example.project1.Service.InstructorService;
import com.example.project1.model.Course;
import com.example.project1.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    private InstructorService service;

    //get all instructors
    @GetMapping("/instructor")
    public List<Instructor> getAllInstructors(){
        return service.getAllInstructors();
    }

    //get instructor by id
    @GetMapping("/instructor/{Id}")
    public Instructor getInstructorById(@PathVariable int Id){
        return service.getInstructorById(Id);
    }

    //Post method for instructor
    @PostMapping("/instructor")
    public void addInstructor(@RequestBody Instructor inst){
        System.out.println(inst);
        service.addInstructor(inst);
    }

    //Put method for instructor
    @PutMapping("instructor/{Id}")
    public void updateInstructor(@PathVariable Integer Id, @RequestBody Instructor instructor){
        service.updateInstructor(Id, instructor);
    }

    //Delete method for instructor
    @DeleteMapping("/instructor/{Id}")
    public void deleteInstructor(@PathVariable int Id){
        service.deleteInstructor(Id);
    }

}

package com.example.project1.Controller;


import com.example.project1.Service.QuizAttendedService;
import com.example.project1.model.Question;
import com.example.project1.model.QuizAttended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizAttendedController {

    @Autowired
    private QuizAttendedService service;

    //get all 
    @GetMapping("/quiz_attended")
    public List<QuizAttended> getAllQuizAttended(){
        return service.getAllQuizAttended();
    }

    //get quiz_attended by id
    @GetMapping("/quiz_attended/{Id}")
    public QuizAttended getQuizAttendedById(@PathVariable int Id){
        return service.getQuizAttendedById(Id);
    }

    //Post method for quiz_attended
    @PostMapping("/quiz_attended")
    public void addQuizAttended(@RequestBody QuizAttended quiz_attended){
        System.out.println(quiz_attended);
        service.addQuizAttended(quiz_attended);
    }

    //Put method for quiz_attended
    @PutMapping("quiz_attended/{Id}")
    public void updateQuizAttended(@PathVariable Integer Id, @RequestBody QuizAttended quiz_attended){
        service.updateQuizAttended(Id, quiz_attended);
    }

    //Delete method for quiz_attended
    @DeleteMapping("/quiz_attended/{Id}")
    public void deleteQuizAttended(@PathVariable int Id){
        service.deleteQuizAttended(Id);
    }
}

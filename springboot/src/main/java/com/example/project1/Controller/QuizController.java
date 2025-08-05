package com.example.project1.Controller;


import com.example.project1.Service.QuizService;
import com.example.project1.model.Quiz;
import com.example.project1.model.QuizAttended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    private QuizService service;

    //get all quiz
    @GetMapping("/quiz")
    public List<Quiz> getAllQuiz(){
        return service.getAllQuiz();
    }

    //get quiz by id
    @GetMapping("/quiz/{Id}")
    public Quiz getQuizById(@PathVariable int Id){
        return service.getQuizById(Id);
    }

    //Post method for quiz
    @PostMapping("/quiz")
    public void addQuiz(@RequestBody Quiz quiz){
        System.out.println(quiz);
        service.addQuiz(quiz);
    }

    //Put method for quiz
    @PutMapping("quiz/{Id}")
    public void updateQuiz(@PathVariable Integer Id, @RequestBody Quiz quiz){
        service.updateQuiz(Id, quiz);
    }

    //Delete method for quiz
    @DeleteMapping("/quiz/{Id}")
    public void deleteQuiz(@PathVariable int Id){
        service.deleteQuiz(Id);
    }
}

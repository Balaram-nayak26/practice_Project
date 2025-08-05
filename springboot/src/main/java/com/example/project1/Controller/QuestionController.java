package com.example.project1.Controller;


import com.example.project1.Service.QuestionService;
import com.example.project1.model.Module;
import com.example.project1.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private QuestionService service;

    //get all question
    @GetMapping("/question")
    public List<Question> getAllQuestion(){
        return service.getAllQuestion();
    }

    //get question by id
    @GetMapping("/question/{Id}")
    public Question getQuestionById(@PathVariable int Id){
        return service.getQuestionById(Id);
    }

    //Post method for question
    @PostMapping("/question")
    public void addQuestion(@RequestBody Question question){
        System.out.println(question);
        service.addQuestion(question);
    }

    //Put method for question
    @PutMapping("question/{Id}")
    public void updateQuestion(@PathVariable Integer Id, @RequestBody Question question){
        service.updateQuestion(Id, question);
    }

    //Delete method for question
    @DeleteMapping("/question/{Id}")
    public void deleteQuestion(@PathVariable int Id){
        service.deleteQuestion(Id);
    }
}

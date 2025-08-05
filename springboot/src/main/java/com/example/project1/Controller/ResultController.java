package com.example.project1.Controller;

import com.example.project1.Service.ResultService;
import com.example.project1.model.Quiz;
import com.example.project1.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultController {

    @Autowired
    private ResultService service;

    //get all result
    @GetMapping("/result")
    public List<Result> getAllResult(){
        return service.getAllResult();
    }

    //get result by id
    @GetMapping("/result/{Id}")
    public Result getResultById(@PathVariable int Id){
        return service.getResultById(Id);
    }

    //Post method for result
    @PostMapping("/result")
    public void addResult(@RequestBody Result result){
        System.out.println(result);
        service.addResult(result);
    }

    //Put method for result
    @PutMapping("result/{Id}")
    public void updateResult(@PathVariable Integer Id, @RequestBody Result result){
        service.updateResult(Id, result);
    }

    //Delete method for result
    @DeleteMapping("/result/{Id}")
    public void deleteResult(@PathVariable int Id){
        service.deleteResult(Id);
    }
}

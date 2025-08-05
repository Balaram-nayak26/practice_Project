package com.example.project1.Service;

import com.example.project1.Repo.ResultRepo;

import com.example.project1.model.Result;
import com.example.project1.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    @Autowired
    private ResultRepo repo;

    //get all
    public List<Result> getAllResult() {
        return repo.findAll();
    }

    //get by id
    public Result getResultById(int id) {
        return repo.findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
    }

    //post
    public void addResult(Result result) {
        repo.save(result);
    }

    // update
    public void updateResult(Integer id, com.example.project1.model.Result updatedResult){
        Optional<Result> optionalResult = repo.findById(id);

        if ( optionalResult.isPresent()){
            Result existingResult = optionalResult.get();

            if (updatedResult.getDate() != null){
                existingResult.setDate((updatedResult.getDate()));
            }
            if (updatedResult.getMarks() != 0){
                existingResult.setMarks((updatedResult.getMarks()));
            }
            if (updatedResult.getQuiz_attended() != null){
                existingResult.setQuiz_attended((updatedResult.getQuiz_attended()));
            }

            repo.save(existingResult);
        }
    }


    //delete
    public void deleteResult(int id) {
        repo.deleteById(id);
    }
}

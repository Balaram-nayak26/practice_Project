package com.example.project1.Service;

import com.example.project1.Repo.QuizRepo;
import com.example.project1.model.Quiz;
import com.example.project1.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepo repo;

    //get
    public List<Quiz> getAllQuiz() {
        return repo.findAll();
    }

    //get by id
    public Quiz getQuizById(int id) {
        return repo.findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
    }

    //post
    public void addQuiz(Quiz quiz) {
        repo.save(quiz);
    }

    //update
    public void updateQuiz(Integer id, com.example.project1.model.Quiz updatedQuiz){
        Optional<Quiz> optionalQuiz = repo.findById(id);

        if ( optionalQuiz.isPresent()){
            Quiz existingQuiz = optionalQuiz.get();

            if (updatedQuiz.getName() != null){
                existingQuiz.setName((updatedQuiz.getName()));
            }
            if (updatedQuiz.getModule() != null){
                existingQuiz.setModule((updatedQuiz.getModule()));
            }

            repo.save(existingQuiz);
        }
    }

    //delete
    public void deleteQuiz(int id) {
        repo.deleteById(id);
    }
}

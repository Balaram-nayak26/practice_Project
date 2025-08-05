package com.example.project1.Service;

import com.example.project1.Repo.QuestionRepo;
import com.example.project1.model.Question;
import com.example.project1.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuestionService {

    @Autowired
    private QuestionRepo repo;

    //get all
    public List<Question> getAllQuestion() {
        return repo.findAll();
    }

    //get by id
    public Question getQuestionById(int id) {
        return repo.findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
    }

    //post
    public void addQuestion(Question question) {
        repo.save(question);
    }

    // update
    public void updateQuestion(Integer id, com.example.project1.model.Question updatedQuestion){
        Optional<com.example.project1.model.Question> optionalQuestion = repo.findById(id);

        if ( optionalQuestion.isPresent()){
            Question existingQuestion = optionalQuestion.get();

            if (updatedQuestion.getQuestion() != null){
                existingQuestion.setQuestion((updatedQuestion.getQuestion()));
            }
            if (updatedQuestion.getPoint() != 0){
                existingQuestion.setPoint((updatedQuestion.getPoint()));
            }
            if (updatedQuestion.getQuiz() != null){
                existingQuestion.setQuiz((updatedQuestion.getQuiz()));
            }

            repo.save(existingQuestion);
        }
    }

    //delete
    public void deleteQuestion(int id) {
        repo.deleteById(id);
    }
}

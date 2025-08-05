package com.example.project1.Service;

import com.example.project1.Repo.QuizAttendedRepo;
import com.example.project1.model.QuizAttended;
import com.example.project1.model.QuizAttended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizAttendedService {

    @Autowired
    private QuizAttendedRepo repo;


    //get all courses
    public List<QuizAttended> getAllQuizAttended() {
        return repo.findAll();
    }

    // get courses by id
    public QuizAttended getQuizAttendedById(int Id) {
        return repo.findAll().stream()
                .filter(p -> p.getId() == Id)
                .findFirst().get();
    }

    //add new course
    public void addQuizAttended(QuizAttended quiz_attended)
    { repo.save(quiz_attended);}

    //update new course
    public void updateQuizAttended(Integer id, com.example.project1.model.QuizAttended updatedQuizAttended){
        Optional<QuizAttended> optionalQuizAttended = repo.findById(id);

        if ( optionalQuizAttended.isPresent()){
            QuizAttended existingQuizAttended = optionalQuizAttended.get();

            if (updatedQuizAttended.getStudent() != null){
                existingQuizAttended.setStudent((updatedQuizAttended.getStudent()));
            }
            if (updatedQuizAttended.getQuiz() != null){
                existingQuizAttended.setQuiz((updatedQuizAttended.getQuiz()));
            }

            repo.save(existingQuizAttended);
        }
    }

    //delete
    public void deleteQuizAttended(int id) {
        repo.deleteById(id);
    }
}

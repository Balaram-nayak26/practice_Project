package com.example.project1.Service;


import com.example.project1.Repo.StudentRepo;
import com.example.project1.model.Student;
import com.example.project1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    //get all students
    public List<Student> getAllStudent() { return repo.findAll();
    }

    //get student by id
    public Student getStudentById(int id) {
        return repo.findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
    }

    //post for student
    public void addStudent(Student student) {
        repo.save(student);
    }

    //update for student
    public void updateStudent(Integer id, com.example.project1.model.Student updatedStudent){
        Optional<Student> optionalStudent = repo.findById(id);

        if ( optionalStudent.isPresent()){
            Student existingStudent = optionalStudent.get();

            if (updatedStudent.getFirst_name() != null){
                existingStudent.setFirst_name((updatedStudent.getFirst_name()));
            }
            if (updatedStudent.getLast_name() != null){
                existingStudent.setLast_name((updatedStudent.getLast_name()));
            }
            if (updatedStudent.getAge() != 0){
                existingStudent.setAge((updatedStudent.getAge()));
            }
            if (updatedStudent.getEmail() != null){
                existingStudent.setEmail((updatedStudent.getEmail()));
            }
            if (updatedStudent.getAverage_quiz_score() != null){
                existingStudent.setAverage_quiz_score((updatedStudent.getAverage_quiz_score()));
            }

            repo.save(existingStudent);
        }
    }

    //delete for student
    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}

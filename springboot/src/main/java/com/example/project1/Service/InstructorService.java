package com.example.project1.Service;

import com.example.project1.Repo.InstructorRepo;
import com.example.project1.model.Instructor;
import com.example.project1.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepo repo;

    //get all instructor
    public List<Instructor> getAllInstructors() {
        return repo.findAll();
    }

    //get instructor by id
    public Instructor getInstructorById(int Id) {
        return repo.findAll().stream()
                .filter(p -> p.getId() == Id)
                .findFirst().get();
    }

    //add new instructor
    public void addInstructor(Instructor inst) { repo.save(inst);
    }

    //update instructor details
    public void updateInstructor(Integer id, Instructor updatedInstructor){
        Optional<Instructor> optionalInstructor = repo.findById(id);

        if ( optionalInstructor.isPresent()){
            Instructor existingInstructor = optionalInstructor.get();

            if (updatedInstructor.getFirst_name() != null){
                existingInstructor.setFirst_name((updatedInstructor.getFirst_name()));
            }
            if (updatedInstructor.getLast_name() != null){
                existingInstructor.setLast_name((updatedInstructor.getLast_name()));
            }
            if (updatedInstructor.getEmail() != null){
                existingInstructor.setEmail((updatedInstructor.getEmail()));
            }

            repo.save(existingInstructor);
        }
    }

    //delete instructor
    public void deleteInstructor(int id) { repo.deleteById(id);
    }
}
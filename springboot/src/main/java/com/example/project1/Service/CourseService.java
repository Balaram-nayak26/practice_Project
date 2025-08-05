package com.example.project1.Service;

import com.example.project1.Repo.CourseRepo;
import com.example.project1.model.Course;
import com.example.project1.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepo repo;

    //get all courses
    public List<Course> getAllCourse() {
        return repo.findAll();
    }

    // get courses by id
    public Course getCourseById(int id) {
        return repo.findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
    }

    //add new course
    public void addCourse(Course course) { repo.save(course);}

    //update new course
    public void updateCourse(Integer id, Course updatedCourse){
        Optional<Course> optionalCourse = repo.findById(id);

        if ( optionalCourse.isPresent()){
            Course existingCourse = optionalCourse.get();

            if (updatedCourse.getName() != null){
                existingCourse.setName((updatedCourse.getName()));
            }
            if (updatedCourse.getDuration() != null){
                existingCourse.setDuration((updatedCourse.getDuration()));
            }
            if (updatedCourse.getInstructor() != null){
                existingCourse.setInstructor((updatedCourse.getInstructor()));
            }

            repo.save(existingCourse);
        }
    }

    //delete courses
    public void deleteCourse(int id) { repo.deleteById(id);
    }
}

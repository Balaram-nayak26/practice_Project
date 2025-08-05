package com.example.project1.Service;

import com.example.project1.Repo.CourseEnrollmentRepo;
import com.example.project1.model.CourseEnrollment;
import com.example.project1.model.CourseEnrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseEnrollmentService {

    @Autowired
    private CourseEnrollmentRepo repo;


    //get all courses
    public List<CourseEnrollment> getAllCourseEnrollment() {
        return repo.findAll();
    }

    // get courses by id
    public CourseEnrollment getCourseEnrollmentById(int Id) {
        return repo.findAll().stream()
                .filter(p -> p.getId() == Id)
                .findFirst().get();
    }

    //add new course
    public void addCourseEnrollment(CourseEnrollment course_enrollment)
    { repo.save(course_enrollment);}

    //update new course
    public void updateCourseEnrollment(Integer id, CourseEnrollment updatedCourseEnrollment){
        Optional<CourseEnrollment> optionalCourseEnrollment = repo.findById(id);

        if ( optionalCourseEnrollment.isPresent()){
            CourseEnrollment existingCourseEnrollment = optionalCourseEnrollment.get();

            if (updatedCourseEnrollment.getStudent() != null){
                existingCourseEnrollment.setStudent((updatedCourseEnrollment.getStudent()));
            }
            if (updatedCourseEnrollment.getCourse() != null){
                existingCourseEnrollment.setCourse((updatedCourseEnrollment.getCourse()));
            }

            repo.save(existingCourseEnrollment);
        }
    }

    //delete
    public void deleteCourseEnrollment(int id) {
        repo.deleteById(id);
    }
}

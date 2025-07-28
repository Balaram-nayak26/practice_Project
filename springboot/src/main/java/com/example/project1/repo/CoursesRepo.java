package com.example.project1.repo;


import com.example.project1.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepo extends JpaRepository<Courses, Integer> {
}

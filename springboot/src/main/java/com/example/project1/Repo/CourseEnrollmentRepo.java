package com.example.project1.Repo;

import com.example.project1.model.CourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEnrollmentRepo extends JpaRepository<CourseEnrollment, Integer> {
}

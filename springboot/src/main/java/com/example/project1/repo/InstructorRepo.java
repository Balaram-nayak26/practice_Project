package com.example.project1.repo;

import com.example.project1.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor, Integer> {
}

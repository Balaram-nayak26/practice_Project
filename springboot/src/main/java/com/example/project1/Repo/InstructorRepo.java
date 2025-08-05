package com.example.project1.Repo;

import com.example.project1.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Integer> {
}

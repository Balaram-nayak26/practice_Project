package com.example.project1.Repo;

import com.example.project1.model.QuizAttended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizAttendedRepo extends JpaRepository<QuizAttended, Integer> {
}

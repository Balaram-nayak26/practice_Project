package com.example.project1.repo;

import com.example.project1.model.Quizzes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizzesRepo extends JpaRepository<Quizzes, Integer> {
}

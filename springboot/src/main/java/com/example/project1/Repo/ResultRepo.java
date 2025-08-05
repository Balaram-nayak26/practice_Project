package com.example.project1.Repo;

import com.example.project1.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository< Result, Integer> {
}

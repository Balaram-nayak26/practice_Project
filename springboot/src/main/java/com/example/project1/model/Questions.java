package com.example.project1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Questions")
public class Questions {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "question")
    private String question;

    @Column(name = "point")
    private int point;

    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "id")
    private Quizzes quizzes;
}

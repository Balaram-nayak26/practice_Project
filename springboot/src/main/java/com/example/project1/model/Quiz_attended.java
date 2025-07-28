package com.example.project1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Quiz_attended")
public class Quiz_attended {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "s_id", referencedColumnName = "id")
    private Students students;

    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "id")
    private Quizzes quizzes;

}

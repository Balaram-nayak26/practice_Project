package com.example.project1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "Result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "marks")
    private int marks;

    @Column(name = "date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "quiz_attended_id", referencedColumnName = "id")
    private QuizAttended quiz_attended;

}

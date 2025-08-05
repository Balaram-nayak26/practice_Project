package com.example.project1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rating")
    private BigDecimal rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "courseEnrollment_id", referencedColumnName = "id")
    private CourseEnrollment courseEnrollment;

}

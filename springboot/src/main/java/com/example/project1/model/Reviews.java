package com.example.project1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
@Table(name = "Reviews")
public class Reviews {

    @Id
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Course_enrollment courseEnrollment;

    @Column(name = "rating")
    private BigDecimal rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    private Date date;

}

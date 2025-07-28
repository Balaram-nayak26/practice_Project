package com.example.project1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "Results")
public class Results {

    @Id
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Quiz_attended quiz_attended;

    @Column(name = "marks")
    private int marks;

    @Column(name = "date")
    private Date date;
}

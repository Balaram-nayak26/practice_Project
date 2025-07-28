package com.example.project1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Courses")
public class Courses {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private String duration;

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Instructor instructor;

}

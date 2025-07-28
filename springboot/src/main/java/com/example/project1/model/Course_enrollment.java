package com.example.project1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Course_enrollment")
public class Course_enrollment {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "c_id", referencedColumnName = "id")
    private Courses courses;

    @ManyToOne
    @JoinColumn(name = "s_id", referencedColumnName = "id")
    private Students students;
}

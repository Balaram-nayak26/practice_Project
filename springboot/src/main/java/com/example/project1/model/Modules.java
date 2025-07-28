package com.example.project1.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "Modules")
public class Modules {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Courses courses;

}

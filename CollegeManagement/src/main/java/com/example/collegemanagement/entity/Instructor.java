package com.example.collegemanagement.entity;

import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String eamil; // typo kept same as DB column

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    @JsonIgnore // Prevent infinite JSON loop
    private List<Course> courses;

    public Instructor() { }

    public Instructor(Long id, String name, String eamil, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.eamil = eamil;
        this.courses = courses;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEamil() { return eamil; }
    public void setEamil(String eamil) { this.eamil = eamil; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}

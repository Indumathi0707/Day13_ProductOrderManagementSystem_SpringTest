package com.example.collegemanagement.entity;

import java.util.List;

import jakarta.persistence.*;

import jakarta.persistence.Id;


@Entity

public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	
	public Course() {
		
	}
	
	public Course(long id, String title, Department department, Instructor instructor, List<Student> student) {
		
		this.id = id;
		this.title = title;
		this.department = department;
		this.instructor = instructor;
		this.student = student;
	}



	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@OneToMany(mappedBy = "course", cascade=CascadeType.ALL)
	private List<Student> student;
	
}

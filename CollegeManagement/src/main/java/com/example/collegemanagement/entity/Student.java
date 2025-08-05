package com.example.collegemanagement.entity;

import jakarta.persistence.*;


@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	
	
	
	public Student() {
	
	}

	public Student(Long id, String name, String email, Course course) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.course = course;
	}



	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
}

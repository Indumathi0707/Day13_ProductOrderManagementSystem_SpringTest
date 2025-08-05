package com.example.collegemanagement.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Course> course;

	public Department() {
	}

	public Department(Long id, String name, List<Course> course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}
}

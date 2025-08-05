package com.example.collegemanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.collegemanagement.entity.Department;

public interface DepartmentRepo  extends JpaRepository<Department, Long>{
	
}

package com.example.collegemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.collegemanagement.entity.Course;
import com.example.collegemanagement.entity.Department;
import com.example.collegemanagement.entity.Instructor;
import com.example.collegemanagement.entity.Student;
import com.example.collegemanagement.repository.CourseRepo;
import com.example.collegemanagement.repository.DepartmentRepo;
import com.example.collegemanagement.repository.InstructorRepo;
import com.example.collegemanagement.repository.StudentRepo;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private StudentRepo stRepo;

    @Autowired
    private CourseRepo crRepo;

    @Autowired
    private InstructorRepo instRepo;

    @Autowired
    private DepartmentRepo deptRepo;

    // ---------- Department ----------
    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department d) {
        return deptRepo.save(d);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return deptRepo.findAll();
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> getDepartmentById(@PathVariable long id) {
        return deptRepo.findById(id);
    }

    // ---------- Instructor ----------
    @PostMapping("/instructors")
    public Instructor addInstructor(@RequestBody Instructor i) {
        return instRepo.save(i);
    }

    @GetMapping("/instructors")
    public List<Instructor> getInstructors() {
        return instRepo.findAll();
    }

    @GetMapping("/instructors/{id}")
    public Optional<Instructor> getInstructorById(@PathVariable long id) {
        return instRepo.findById(id);
    }

    // ---------- Student ----------
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student s) {
        return stRepo.save(s);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return stRepo.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable long id) {
        return stRepo.findById(id);
    }

    // ---------- Course ----------
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course c) {
        return crRepo.save(c);
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return crRepo.findAll();
    }

    @GetMapping("/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable long id) {
        return crRepo.findById(id);
    }
}

package com.company.employeeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public Map<String, Object> getEmployee() {
        return Map.of(
                "id", 101,
                "name", "John Doe",
                "department", "Engineering"
        );
    }
}

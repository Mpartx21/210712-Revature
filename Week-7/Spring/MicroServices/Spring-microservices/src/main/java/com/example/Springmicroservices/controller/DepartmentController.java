package com.example.Springmicroservices.controller;

import com.example.Springmicroservices.entity.Department;
import com.example.Springmicroservices.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/departments")
    public List<Department> getDepartment(){
        return service.getDepartments();
    }

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return service.saveDepartment(department);
    }


}

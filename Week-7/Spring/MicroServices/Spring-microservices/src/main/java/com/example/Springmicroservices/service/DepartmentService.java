package com.example.Springmicroservices.service;

import com.example.Springmicroservices.entity.Department;
import com.example.Springmicroservices.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department saveDepartment(Department department){
        return departmentRepo.save(department);
    }

    public List<Department> getDepartments(){
        return departmentRepo.findAll();
    }
}

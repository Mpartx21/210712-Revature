package com.revature.withAngular.services;

import com.revature.withAngular.exceptions.UserNotFoundException;
import com.revature.withAngular.model.Employee;
import com.revature.withAngular.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
        //The employeeRepo is having access to all of its functions in the Jpa
        //Spring Data--/
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById (Long employee) throws UserNotFoundException {
       return employeeRepo.findEmployeeById(employee).orElseThrow(() -> new UserNotFoundException("User by id "+ employee +" was not found"));
    }

    public void deleteEmployee (Long employee){
        employeeRepo.deleteEmployeeById(employee);
    }
}

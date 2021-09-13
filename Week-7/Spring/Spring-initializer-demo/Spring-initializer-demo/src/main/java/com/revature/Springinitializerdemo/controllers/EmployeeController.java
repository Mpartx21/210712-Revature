package com.revature.Springinitializerdemo.controllers;

import com.revature.Springinitializerdemo.Services.EmployeeService;
import com.revature.Springinitializerdemo.Services.EmployeeServiceImpl;
import com.revature.Springinitializerdemo.entities.Employee;
import com.revature.Springinitializerdemo.repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        LOGGER.info("awsdkl;fjlasdk;fjldks;afjlk;dsajfk");
        return service.saveEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getEmployee(){
        LOGGER.info("get all list employee");
        return service.fetchEmployeeList();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") long employeeId){
        return service.fetchEmployeeById(employeeId);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") long employeeId){
        service.deleteEmployeeById(employeeId);
        return "employee Deleteed";
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee){
        return service.updateEmployee(employeeId,employee);
    }
    @GetMapping("/employees/name/{name}")
    public Employee fetchEmployeeByName(@PathVariable("name")String employeeName){
        return service.fetchEmployeeByName(employeeName);
    }

}

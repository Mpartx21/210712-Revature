package com.revature.Springinitializerdemo.Services;

import com.revature.Springinitializerdemo.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    public List<Employee> fetchEmployeeList();
    public Employee fetchEmployeeById(long employeeId);
    public void deleteEmployeeById(long employeeId);
    public Employee updateEmployee(long employeeId, Employee employee);
    public Employee fetchEmployeeByName(String employeeName);
}

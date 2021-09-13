package com.revature.Springinitializerdemo.Services;

import com.revature.Springinitializerdemo.entities.Employee;
import com.revature.Springinitializerdemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return repository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(long employeeId) {
     Optional<Employee> employee = repository.findById(employeeId);
     if(!employee.isPresent()){
         System.out.println("employee id does not exists");
     }
     return employee.get();
    }

    @Override
    public void deleteEmployeeById(long employeeId) {
        repository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployee(long employeeId, Employee employee) {
        Employee employeedb = repository.findById(employeeId).get();
        if(Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())){
            employeedb.setEmployeeName(employee.getEmployeeName());
        }
        if(Objects.nonNull(employee.getEmployeeAddress()) && !"".equalsIgnoreCase(employee.getEmployeeAddress())){
            employeedb.setEmployeeAddress(employee.getEmployeeAddress());
        }
        if(Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())){
            employeedb.setEmployeeName(employee.getEmployeeName());
        }
        return repository.save(employeedb);
    }

    @Override
    public Employee fetchEmployeeByName(String employeeName) {
        return repository.findByEmployeeName(employeeName);
    }
}

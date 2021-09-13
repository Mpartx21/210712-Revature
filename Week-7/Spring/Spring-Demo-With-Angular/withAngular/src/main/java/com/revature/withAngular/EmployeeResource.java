package com.revature.withAngular;

import com.revature.withAngular.model.Employee;
import com.revature.withAngular.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;


    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
//Returns http Response that is ResponseEntity
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    //Returns http Response that is ResponseEntity
    @GetMapping("/find/{id}")
    //PathVariable and GetMapping annotations are pointing toward eachother
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);

        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    //Returns http Response that is ResponseEntity
    //PostMapping is for making a change to the database
    @PostMapping("/add")
    //Expecting WHOLE Employee JSON object that will be coming from the user
    //RequestBody is what is suppose to be coming from the body of the request\
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee ){
        Employee employeeToAdd = employeeService.addEmployee(employee);

        return new ResponseEntity<>(employeeToAdd,HttpStatus.CREATED);
    }

    //Returns http Response that is ResponseEntity
    //PostMapping is for making a change to the database
    @PutMapping("/update")
    //Expecting WHOLE Employee JSON object that will be coming from the user
    //RequestBody is what is suppose to be coming from the body of the request
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee ){
        Employee updateEmployee = employeeService.updateEmployee(employee);

        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }


    @PutMapping("/delete/{id}")
    //will delete object and send back an ok response
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

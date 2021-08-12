package com.revature.service;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDOAFactory;
import com.revature.exception.AuthenticateException;
import com.revature.exception.DuplicateEmailException;
import com.revature.models.Employee;

import java.sql.SQLException;
import java.util.Optional;

import static com.revature.Main.programManager;

public class EmployeeService {
    private static EmployeeDAO employeeDAO= null;

    public EmployeeService() throws SQLException{
        employeeDAO = EmployeeDOAFactory.getEmployeeDAO();
    }

    public void authenticateEmployee(String email,String password) throws SQLException, AuthenticateException {
        Employee authenticatedEmployee = employeeDAO.EmployeeByEmailAndPassword(email,password);
        if (authenticatedEmployee == null){
            throw new AuthenticateException("Please choose different login");
        }else{
            programManager.setEmployee(authenticatedEmployee);
        }
    }
    public  void registerEmployee(Employee employee) throws SQLException, DuplicateEmailException {
        Optional<Employee> exisitingEmployee = Optional.ofNullable(employeeDAO.EmployeeByEmailAndPassword(employee.getEmail(), employee.getPassword()));

        if(exisitingEmployee.isPresent()){
            throw new DuplicateEmailException();
        }
        employeeDAO.addEmployee(employee);
        programManager.setEmployee(EmployeeDOAFactory.getEmployeeDAO().EmployeeByEmailAndPassword(employee.getEmail(), employee.getPassword()));
    }
}

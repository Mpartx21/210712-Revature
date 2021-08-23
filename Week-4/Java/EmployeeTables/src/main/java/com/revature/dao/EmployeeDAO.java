package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDAO {
    void addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int id) throws SQLException;
    List<Employee> getEmployess() throws SQLException, ClassNotFoundException;
    Employee employeeByID(int id) throws SQLException, ClassNotFoundException;

}

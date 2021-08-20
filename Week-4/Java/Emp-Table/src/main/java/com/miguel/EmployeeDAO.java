package com.miguel;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    boolean addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int id) throws SQLException;
    List<Employee> getEmployess() throws SQLException, ClassNotFoundException;
    Employee employeeByID(int id) throws SQLException, ClassNotFoundException;

}

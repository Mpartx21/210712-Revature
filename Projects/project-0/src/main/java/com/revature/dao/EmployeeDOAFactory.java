package com.revature.dao;

import java.sql.SQLException;

public class EmployeeDOAFactory {
    private static EmployeeDAO employeeDAO;
    private EmployeeDOAFactory(){}
    public static EmployeeDAO getEmployeeDAO()throws SQLException{
        if (employeeDAO == null){
            employeeDAO = new EmployeeDAOImpl();
        }
        return employeeDAO;
    }
}

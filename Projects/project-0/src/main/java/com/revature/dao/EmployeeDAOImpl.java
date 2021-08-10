package com.revature.dao;


import com.revature.models.Employee;
import com.revature.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    public EmployeeDAOImpl() {
        this.connection = ConnectionFactory.getInstance().getConnection();
    }


    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "insert into employee " +
                "(employe_name,employee_email,employee_password)" +
                " values (?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setString(3, employee.getPassword());
        int count = preparedStatement.executeUpdate();
        if (count > 0){
            System.out.println("Employee Added");
        }else {
            System.out.println("Ooops! Something went wrong");
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "update employee set employee_name = ?, employee_email = ?,employee_password = ? where employee_id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2,employee.getEmail());
        preparedStatement.setString(3, employee.getPassword());
        preparedStatement.setInt(4,employee.getId());
        int count = preparedStatement.executeUpdate();
        if(count > 0) {
            System.out.println("employee updated");
        }else{
            System.out.println("Oops! something went wrong");
        }
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "delete from employee where id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if(count > 0) {
            System.out.println("employee deleted");
        }else{
            System.out.println("Oops! something went wrong");
        }
    }

    @Override
    public List<Employee> getEmployee() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "select * from employee";
        Statement preparedStatement = connection.createStatement();
        ResultSet resultSet = preparedStatement.executeQuery(sql);

        while (resultSet.next()){
//            populate an employee object when it is iterated through
            int employeeId = resultSet.getInt("employee_id");
            String name = resultSet.getString("employee_name");
            String email = resultSet.getString("employee_email");

            Employee employee = new Employee(employeeId,name,email);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public Employee EmployeeByEmailAndPassword(String email, String password) throws SQLException {
        Employee employee = null;
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "select * from employee where employee_email = ? and employee_password = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            int id = resultSet.getInt("employee_id");
            String name = resultSet.getString("employee_name");
            String newEmail = resultSet.getString("employee_email");
            String newPassword = resultSet.getString("employee_password");
            employee = new Employee(id,name,newEmail,newPassword);
        }
        return employee;
    }
}

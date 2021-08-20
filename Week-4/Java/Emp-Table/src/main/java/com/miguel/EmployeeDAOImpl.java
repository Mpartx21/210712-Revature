package com.miguel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    private static Statement statement = null;
    private static Connection connection = null;


    public EmployeeDAOImpl() throws SQLException, ClassNotFoundException{
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public boolean addEmployee(Employee employee) throws SQLException {
        String sql = "insert into employee (name, email, gender, country) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setString(3, employee.getGender());
        preparedStatement.setString(4, employee.getCountry());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            return true;
        } else {
           return false;
        }
    }
    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "update employee set name = ?, email = ?,phone = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setString(3,employee.getPhone());
        preparedStatement.setInt(4, employee.getId());
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
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if(count > 0) {
            System.out.println("employee delete");
        }else{
            System.out.println("Oops! something went wrong");
        }
    }

    @Override
    public List<Employee> getEmployess() throws SQLException, ClassNotFoundException{
        List<Employee> employees = new ArrayList<>();
        connection = ConnectionFactory.getConnection();
        String sql = "select * from employee";
        Statement preparedStatement = connection.createStatement();
        ResultSet resultSet = preparedStatement.executeQuery(sql);

        while (resultSet.next()){
//            populate an employee object when it is iterated through
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String gender = resultSet.getString("gender");
            String country = resultSet.getString("country");

            Employee employee = new Employee(id,name,email,gender,country);
            employees.add(employee);
        }
    return employees;
    }

    @Override
    public Employee employeeByID(int id) throws SQLException, ClassNotFoundException {
        Employee employee = null;
        connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM employee WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            int eID = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            employee = new Employee(id,name,email,phone);
        }
        return employee;
    }
}

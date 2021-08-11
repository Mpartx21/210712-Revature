package com.revature.dao;


import com.revature.models.Customer;
import com.revature.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private static PreparedStatement preparedStatement = null;
    private static Connection connection = null;

    public CustomerDAOImpl() {
        this.connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        String sql = "insert into customer " +
                "(customer_name,customer_email,customer_password)" +
                " values (?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,customer.getName());
        preparedStatement.setString(2, customer.getEmail());
        preparedStatement.setString(3, customer.getPassWord());
        int count = preparedStatement.executeUpdate();
        if (count > 0){
            System.out.println("Customer Added");
        }else {
            System.out.println("Ooops! Something went wrong");
        }
    }

    @Override
    public void updateUser(Customer customer) throws SQLException {
        String sql = "update customer set customer_name = ?, customer_email = ?,customer_password = ? where customer_id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2,customer.getEmail());
        preparedStatement.setString(3, customer.getPassWord());
        preparedStatement.setInt(4,customer.getId());
        int count = preparedStatement.executeUpdate();
        if(count > 0) {
            System.out.println("Customer updated");
        }else{
            System.out.println("Oops! something went wrong");
        }
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        String sql = "delete from customer where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if(count > 0) {
            System.out.println("Customer deleted");
        }else{
            System.out.println("Oops! something went wrong");
        }
    }

    @Override
    public List<Customer> getCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "select * from customer";
        Statement preparedStatement = connection.createStatement();
        ResultSet resultSet = preparedStatement.executeQuery(sql);

        while (resultSet.next()){
//            populate an employee object when it is iterated through
            int customerID = resultSet.getInt("customer_id");
            String name = resultSet.getString("customer_name");
            String email = resultSet.getString("customer_email");

            Customer customer = new Customer(customerID,name,email);
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public Customer findByEmail(String email) throws SQLException {
        Customer customer = null;
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "select * from customer where customer_email = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,email);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            int id = resultSet.getInt("customer_id");
            String name = resultSet.getString("customer_name");
            String newEmail = resultSet.getString("customer_email");
            String newPassword = resultSet.getString("customer_password");
            customer = new Customer(id,name,newEmail,newPassword);
        }
        return customer;
    }


    @Override
    public Customer customerByEmailandPassword(String email,String password) throws SQLException {
        Customer customer = null;
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "select * from customer where customer_email = ? and customer_password = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            int id = resultSet.getInt("customer_id");
            String name = resultSet.getString("customer_name");
            String newEmail = resultSet.getString("customer_email");
            String newPassword = resultSet.getString("customer_password");
            customer = new Customer(id,name,newEmail,newPassword);
        }
        return customer;
    }
}

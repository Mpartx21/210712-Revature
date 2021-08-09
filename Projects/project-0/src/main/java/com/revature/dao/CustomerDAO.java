package com.revature.dao;


import com.revature.models.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    void addCustomer(Customer customer) throws SQLException;
    void updateUser(Customer customer) throws SQLException;
    void deleteUser(int id) throws SQLException;
    List<Customer> getUser() throws SQLException;
    Customer customerByEmailandPassword(String email,String password) throws SQLException;
}

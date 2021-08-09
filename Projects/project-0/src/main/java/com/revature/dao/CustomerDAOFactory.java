package com.revature.dao;

import java.sql.SQLException;

public class CustomerDAOFactory {
    private static CustomerDAO customerDAO;

    private CustomerDAOFactory(){}

    public static CustomerDAO getUserDAO() throws SQLException{
        if (customerDAO == null) {
            customerDAO = new CustomerDAOImpl();
        }
        return customerDAO;
    }
}
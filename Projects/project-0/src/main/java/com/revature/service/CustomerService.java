package com.revature.service;

import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOFactory;
import com.revature.exception.AuthenticateException;
import com.revature.exception.DuplicateEmailException;
import com.revature.models.Customer;

import java.sql.SQLException;
import java.util.Optional;

import static com.revature.Main.programManager;

public class CustomerService {
    private static CustomerDAO customerDAO = null;


    public CustomerService() throws SQLException {
        customerDAO = CustomerDAOFactory.getUserDAO();
    }

    public void authenticateCustomer(String email,String password) throws SQLException, AuthenticateException {
        Customer authenticatedCustomer = customerDAO.customerByEmailandPassword(email, password);
       if(authenticatedCustomer == null){
           throw new AuthenticateException("Please Choose another Email.");
       }else {
           programManager.setCustomer(authenticatedCustomer);
       }
    }

    public void registerCustomer(Customer newCustomer) throws SQLException, DuplicateEmailException {
        Optional <Customer> existingCustomer = Optional.ofNullable(customerDAO.findByEmail(newCustomer.getEmail()));

        if(existingCustomer.isPresent()){
            throw new DuplicateEmailException();
        }

        customerDAO.addCustomer(newCustomer);
        programManager.setCustomer(newCustomer);
    }
}

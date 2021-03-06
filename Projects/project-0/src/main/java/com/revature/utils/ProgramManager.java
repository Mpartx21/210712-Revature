package com.revature.utils;

import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOFactory;
import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.screen.*;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Scanner;

public class ProgramManager {
    private Scanner scanner;
    private ScreenNavigator screenNavigator;
    private boolean running;
    private Account account;
    private Customer customer;
    private Employee employee;

    public Logger getLogger() {
        return logger;
    }

    private Logger logger;

    public ProgramManager(){
        employee= new Employee();
        logger =Logger.getLogger(ProgramManager.class.getName());

        running = true;
        scanner = new Scanner(System.in);
        //Initalizing the DAOs
        try {
            CustomerDAO customerDAO = CustomerDAOFactory.getUserDAO();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        screenNavigator = new ScreenNavigator();
        screenNavigator
                .addScreen(new OpeningScreen())
                .addScreen(new CustomerLogin())
                .addScreen(new EmployeeLogin())
                .addScreen(new CustomerRegister())
                .addScreen(new EmployeeRegister())
                .addScreen(new AccountOptions())
                .addScreen(new EmployeeOptions())
                .addScreen(new AddAccount())
                .addScreen(new Withdrawal())
                .addScreen(new Deposit())
                .addScreen(new Transfer())
                .addScreen(new EmployeeTransfers());
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public ScreenNavigator getScreenNavigator() {
        return screenNavigator;
    }

    public void setScreenNavigator(ScreenNavigator screenNavigator) {
        this.screenNavigator = screenNavigator;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

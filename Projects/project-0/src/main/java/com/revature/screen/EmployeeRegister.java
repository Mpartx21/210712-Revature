package com.revature.screen;

import com.revature.exception.DuplicateEmailException;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

import java.sql.SQLException;

import static com.revature.Main.programManager;

public class EmployeeRegister extends Screen{
    public EmployeeRegister() {
        super("employeeRegister");
    }

    @Override
    public void printScreen() {
        try {
            System.out.println("Signing up a new Employee");
            System.out.println("Please provide your name: ");
            String employeeName = programManager.getScanner().nextLine();
            System.out.println("Please provide your email: ");
            String employeeEmail = programManager.getScanner().nextLine().trim();
            System.out.println("Please provide your password:");
            String employeePassword = programManager.getScanner().nextLine();
            new EmployeeService().registerEmployee(new Employee(employeeName,employeeEmail,employeePassword));

            programManager.getScreenNavigator().navigate("employeeOptions");
        }catch (SQLException |DuplicateEmailException e) {
            e.printStackTrace();
            programManager.getScreenNavigator().navigate("first");
        }
    }
}

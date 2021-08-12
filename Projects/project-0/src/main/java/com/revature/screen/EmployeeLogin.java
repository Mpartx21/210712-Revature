package com.revature.screen;

import com.revature.exception.AuthenticateException;
import com.revature.service.EmployeeService;

import java.sql.SQLException;

import static com.revature.Main.programManager;

public class EmployeeLogin extends Screen{


    public EmployeeLogin() {
        super("employeeLogin");
    }

    @Override
    public void printScreen() {
        try{
            System.out.println("Employee Login");
            System.out.println("Please provide your email: ");
            String employeeEmail = programManager.getScanner().nextLine();
            System.out.println("Please provide your password:");
            String employeePassword = programManager.getScanner().nextLine();

            new EmployeeService().authenticateEmployee(employeeEmail,employeePassword);

            if (programManager.getEmployee() != null){
                programManager.getScreenNavigator().navigate("employeeOptions");
            }
        } catch (AuthenticateException | SQLException e) {
            System.out.println("Authentication Failed");
            programManager.getScreenNavigator().navigate("first");
        }
    }
}

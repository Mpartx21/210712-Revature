package com.revature.screen;

import com.revature.dao.AccountDAOFactory;
import com.revature.models.Account;

import java.io.*;
import java.sql.SQLException;
import java.util.stream.Collectors;

import static com.revature.Main.programManager;

public class EmployeeOptions extends Screen {
    public EmployeeOptions() {
        super("employeeOptions");
    }

    @Override
    public void printScreen() {
        try {
            System.out.println("Employee Options\n" +
                    "1: Show Customers and Accounts\n" +
                    "2: View Logs\n" +
                    "3. Money Transfers\n" +
                    "4. Sign Out");
            switch (programManager.getScanner().nextLine()) {
                case "1":
                    printAccountsandCustomers();
                    programManager.getScreenNavigator().navigate("employeeOptions");
                    break;
                case "2":
                    printLogs();
                    programManager.getScreenNavigator().navigate("employeeOptions");
                    break;
                case "3":
                    programManager.getScreenNavigator().navigate("employeeTransfer");
                    break;
                case "4":
                    programManager.setEmployee(null);
                    programManager.getScreenNavigator().navigate("first");
                    break;
                default:
                    System.out.println("Try Something Else");
                    programManager.getScreenNavigator().navigate("employeeOptions");
            }
        } catch (SQLException e) {
            System.out.println("failed");
            programManager.getScreenNavigator().navigate("employeeOptions");
        }
    }

    public void printLogs(){
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("src\\\\main\\\\resources\\\\log4j.log");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String logLine = null;
            while ((logLine = bufferedReader.readLine()) != null) {
                System.out.println(logLine);
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("Problem reading");
        }
    }
    public void printAccountsandCustomers() throws SQLException {
        AccountDAOFactory.getAccountDAO()
                .getAllAccounts()
                .stream()
                .sorted((Account a1,Account a2) ->
                    a1.getCustomerID().compareTo(a2.getCustomerID()))
                .collect(Collectors.toList())
                .stream().forEach(account -> {
            System.out.println("Customer ID: " + account.getCustomerID()+
                    " Account ID: " + account.getAccountID()+
                    " Account Type: "+ account.getTypes().toString()+
                    " Balance: " + account.getBalance());
        });
    }
}

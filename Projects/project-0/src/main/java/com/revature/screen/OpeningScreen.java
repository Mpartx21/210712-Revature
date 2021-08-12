package com.revature.screen;

import com.revature.dao.CustomerDAOFactory;
import com.revature.dao.EmployeeDOAFactory;

import static com.revature.Main.programManager;

public class OpeningScreen extends Screen {
    public OpeningScreen() {
        super("first");
    }

    @Override
    public void printScreen() {
        programManager.getLogger().info("Opening Bank Console");

        System.out.println("Opening Screen");
        System.out.println("1: Customer Login");
        System.out.println("2: Customer Register");
        System.out.println("3: Employee Login");
        System.out.println("4: Employee Register");
        System.out.println("5: Close");
        System.out.println("+-------------------+");



        try{
            CustomerDAOFactory.getUserDAO()
                    .getCustomers().stream()
                    .forEach(customer ->{
                        System.out.println(customer.toString());
                    });
            EmployeeDOAFactory.getEmployeeDAO()
                    .getEmployee().stream()
                    .forEach(employee -> {
        System.out.println(employee.toString());});

            switch (programManager.getScanner().nextLine()){
                case "1":
                    programManager.getScreenNavigator().navigate("customerLogin");
                    break;
                case "2":
                    programManager.getScreenNavigator().navigate("customerRegister");
                    break;
                case "3":
                    programManager.getScreenNavigator().navigate("employeeLogin");
                    break;
                case "4":
                    programManager.getScreenNavigator().navigate("employeeRegister");
                    break;
                case "5":
                    System.out.println("Closing");
                    programManager.setRunning(false);
                    break;
                default:
                    System.out.println("Please Try Again");
                    programManager.getScreenNavigator().navigate("first");
            }

        }catch (Exception e){
            e.printStackTrace();
            programManager.getScreenNavigator().navigate("first");
        }
    }
}

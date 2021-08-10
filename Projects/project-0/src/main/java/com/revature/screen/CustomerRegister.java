package com.revature.screen;

import com.revature.dao.CustomerDAOFactory;
import com.revature.models.Customer;
import com.revature.service.CustomerService;

import static com.revature.Main.programManager;

public class CustomerRegister extends Screen{
    public CustomerRegister( ) {
        super("customerRegister");
    }

    @Override
    public void printScreen(){
        try {
            System.out.println("Signing up for a new Account\n");
            String custName = programManager.getScanner().nextLine();
            System.out.println("Please provide your name: ");
            String custEmail = programManager.getScanner().nextLine();
            System.out.println("Please provide your email: ");
            String custPassword = programManager.getScanner().nextLine();
            System.out.println("Please provide your password:");
            new CustomerService(CustomerDAOFactory.getUserDAO())
                    .registerCustomer(new Customer(custName, custEmail, custPassword));

            programManager.getScreenNavigator().navigate("accountOptions");

        }catch (Exception e){
            programManager.getScreenNavigator().navigate("first");
        }
    }
}

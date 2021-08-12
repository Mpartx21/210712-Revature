package com.revature.screen;

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
            System.out.println("Please provide your name: ");
            String custName = programManager.getScanner().nextLine();
            System.out.println("Please provide your email: ");
            String custEmail = programManager.getScanner().nextLine().trim();
            System.out.println("Please provide your password:");
            String custPassword = programManager.getScanner().nextLine();
            new CustomerService()
                    .registerCustomer(new Customer(custName, custEmail, custPassword));

            programManager.getScreenNavigator().navigate("first");

        }catch (Exception e){
            programManager.getScreenNavigator().navigate("first");
        }
    }
}

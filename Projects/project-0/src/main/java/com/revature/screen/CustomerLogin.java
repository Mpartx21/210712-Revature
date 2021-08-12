package com.revature.screen;

import com.revature.exception.AuthenticateException;
import com.revature.service.CustomerService;

import static com.revature.Main.programManager;

public class CustomerLogin extends Screen{

    public CustomerLogin(){
        super("customerLogin");
    }
    @Override
    public void printScreen() {
        try {
            System.out.println("Customer Login");
            System.out.println("Please provide your email: ");
            String custEmail = programManager.getScanner().nextLine();
            System.out.println("Please provide your password:");
            String custPassword = programManager.getScanner().nextLine();
            new CustomerService().authenticateCustomer(custEmail,custPassword);

            if(programManager.getCustomer() != null){
                programManager.getLogger().info("Customer ID: "+ programManager.getCustomer().getId()+" logged in");
                programManager.getScreenNavigator().navigate("accountOptions");
            }else {
                throw new AuthenticateException("No Customer with those credentials");

            }
        }catch (Exception e){
            programManager.getScreenNavigator().navigate("first");
        }
    }
}

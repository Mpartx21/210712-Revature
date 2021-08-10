package com.revature.screen;

import com.revature.dao.CustomerDAOFactory;
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
            String custEmail = programManager.getScanner().nextLine();
            System.out.println("Please provide your email: ");
            String custPassword = programManager.getScanner().nextLine();
            System.out.println("Please provide your password:");
            new CustomerService(CustomerDAOFactory.getUserDAO()).authenticateCustomer(custEmail,custPassword);

            if(programManager.getCustomer() != null){
                programManager.getScreenNavigator().navigate("accountOptions");
            }else {
                throw new AuthenticateException("No Customer with those credentials");
            }

        }catch (Exception e){
            programManager.getScreenNavigator().navigate("first");
        }
    }
}

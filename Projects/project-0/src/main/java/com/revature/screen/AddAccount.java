package com.revature.screen;

import com.revature.dao.AccountDAOFactory;
import com.revature.models.Account;
import com.revature.models.AccountTypes;

import java.sql.SQLException;

import static com.revature.Main.programManager;

public class AddAccount extends Screen{
    public AddAccount( ) {
        super("addAccount");
    }

    @Override
    public void printScreen() {
        try {
            System.out.println("Adding Account\n" +
                    "Would you like a 'checkings' or 'savings' account?");
            String types = programManager.getScanner().next().trim();
            System.out.println("Please provide your initial deposit: ");
            double balance = programManager.getScanner().nextDouble();
            programManager.setAccount(new Account(programManager.getCustomer().getId(), balance, AccountTypes.getByType(types)));

            AccountDAOFactory.getAccountDAO().addAccount(programManager.getAccount());

            programManager.getScreenNavigator().navigate("accountOptions");
        }catch (SQLException e){
            System.out.println("Problem creating account lets try this again");
            programManager.getScreenNavigator().navigate("accountOptions");
        }
    }
}

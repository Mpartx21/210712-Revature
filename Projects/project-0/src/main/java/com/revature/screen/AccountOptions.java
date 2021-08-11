package com.revature.screen;

import com.revature.dao.AccountDAOFactory;

import static com.revature.Main.programManager;

public class AccountOptions extends Screen{
    public AccountOptions() {
        super("accountOptions");
    }

    @Override
    public void printScreen() {
        try{
            System.out.println("account options");
            System.out.println("1: Add Account\n" +
                               "2: Deposit\n" +
                               "3: Withdrawal\n" +
                               "4: Sign Out\n" +
                               "Accounts: ");
            AccountDAOFactory.getAccountDAO()
                             .getAccountsByCustomerId(programManager.getCustomer().getId())
                             .forEach(account -> {
                                 System.out.println("Account ID: " + account.getAccountID()
                                                    +" Account type: " + account.getTypes().toString().toUpperCase()
                                                    +" Balance: " + account.getBalance());
                             });
            System.out.println("+-------------------+");

            switch (programManager.getScanner().next()) {
                case "1":
                    programManager.getScreenNavigator().navigate("addAccount");
                    break;
                case "2":
                    programManager.getScreenNavigator().navigate("deposit");
                    break;
                case "3":
                    programManager.getScreenNavigator().navigate("withdrawal");
            }
        }catch (Exception e){
            e.printStackTrace();
            programManager.getScreenNavigator().navigate("accountOptions");
        }
    }
}

package com.revature.screen;

import com.revature.dao.AccountDAOFactory;
import com.revature.models.Account;
import com.revature.service.AccountService;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;

import static com.revature.Main.programManager;

public class Withdrawal extends Screen{
    public Withdrawal() {
        super("withdrawal");
    }

    @Override
    public void printScreen() {
        try {
            System.out.println("Withdrawal\n" +
                    "Chose Account ID to withdrawal");
            int account_id = programManager.getScanner().nextInt();
            System.out.println("Enter Withdrawal Amount: ");
            double withdrawal = programManager.getScanner().nextDouble();
            List<Account> accounts = AccountDAOFactory.getAccountDAO().getAccountsByCustomerId(programManager.getCustomer().getId());

            for (Account account:accounts) {
                if (account.getAccountID().equals(account_id)){
                    new AccountService().withdrawal(account, withdrawal);

                    programManager.getScreenNavigator().navigate("accountOptions");
                }
            }
        }catch (SQLException e){
            System.out.println("Could not get Accounts ");
            programManager.getScreenNavigator().navigate("accountOptions");
        }catch (InputMismatchException e){
            System.out.println("Wrong input ");
            programManager.getScreenNavigator().navigate("accountOptions");
        }
    }
}

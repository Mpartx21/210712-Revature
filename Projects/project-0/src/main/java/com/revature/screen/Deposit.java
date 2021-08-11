package com.revature.screen;

import com.revature.dao.AccountDAOFactory;
import com.revature.models.Account;
import com.revature.service.AccountService;

import java.sql.SQLException;
import java.util.List;

import static com.revature.Main.programManager;

public class Deposit extends Screen{

    public Deposit() {
        super("deposit");
    }

    @Override
    public void printScreen() {
        try{
            System.out.println("Depositing\n" +
                               "Choose Account ID to deposit");
            int account_id = programManager.getScanner().nextInt();
            System.out.println("Enter Deposit Amount: ");
            double deposit = programManager.getScanner().nextDouble();

            List<Account> accounts = AccountDAOFactory.getAccountDAO().getAccountsByCustomerId(programManager.getCustomer().getId());

            for (Account account:accounts) {
                if (account.getAccountID().equals(account_id)){
                    new AccountService(AccountDAOFactory.getAccountDAO())
                            .deposit(account, deposit);
                    programManager.getScreenNavigator().navigate("accountOptions");
                }
            }

        }catch (NullPointerException e){
            System.out.println("Wrong input");
        }catch (SQLException e){
            System.out.println("Grabing your accounts was an issue");
        }
    }
}

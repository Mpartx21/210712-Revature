package com.revature.service;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOFactory;
import com.revature.exception.AuthenticateException;
import com.revature.exception.OverWithdrawal;
import com.revature.models.Account;

import java.sql.SQLException;
import java.util.Map;

import static com.revature.Main.programManager;

public class AccountService {
    private static AccountDAO accountDAO = null;

    public AccountService() throws SQLException {
        AccountDAO accountDAO = AccountDAOFactory.getAccountDAO();
    }

    public void deposit(Account account,double deposit) {
        try {
            account.setBalance(account.getBalance() + deposit);

            AccountDAOFactory.getAccountDAO().updateAccount(account);

        }catch (SQLException e){
            System.out.println("updating account failed");
        }
    }

    public void withdrawal(Account account,double withdrawal){
       try {
        double verify = account.getBalance() - withdrawal;

        if(verify < 0){
            throw new OverWithdrawal();
        }

        account.setBalance(verify);

        AccountDAOFactory.getAccountDAO().updateAccount(account);

        }catch (OverWithdrawal | SQLException e){
           System.out.println("Issue with withdrawal");
       }
    }

    public Map<Integer, Account> transfer() throws SQLException, AuthenticateException {
        System.out.println("Choose your Account ID: ");
        int accountToWithdrawal = programManager.getScanner().nextInt();
        System.out.println("Choose account to deposit");
        int accountToDeposit = programManager.getScanner().nextInt();
        Map<Integer,Account> transferAccounts = AccountDAOFactory.getAccountDAO().getAccountsForTransfer(accountToWithdrawal,accountToDeposit);
        System.out.println("Choose your transfer amount");
        double transfer = programManager.getScanner().nextDouble();
        if(transferAccounts.get(accountToWithdrawal).getBalance() - transfer <0){
            throw new AuthenticateException("Transfer Amount Invalid");
        }
        transferAccounts.get(accountToWithdrawal).setBalance(transferAccounts.get(accountToWithdrawal).getBalance() - transfer);
        transferAccounts.get(accountToDeposit).setBalance(transferAccounts.get(accountToDeposit).getBalance() + transfer);
        programManager.getLogger().info("Account ID: "+ accountToWithdrawal +"wants to transfer "+ transfer +"to Account ID: "+ accountToDeposit);
        return transferAccounts;
    }
}

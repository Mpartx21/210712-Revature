package com.revature.service;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOFactory;
import com.revature.exception.OverWithdrawal;
import com.revature.models.Account;

import java.sql.SQLException;

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
}

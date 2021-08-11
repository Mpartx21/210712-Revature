package com.revature.service;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOFactory;
import com.revature.models.Account;

import java.sql.SQLException;

public class AccountService {
    private static AccountDAO accountDAO = null;

    public AccountService(AccountDAO accountDAO) throws SQLException {
        accountDAO = AccountDAOFactory.getAccountDAO();
    }

    public void deposit(Account account,double deposit) {
        try {
            account.setBalance(account.getBalance() + deposit);

            AccountDAOFactory.getAccountDAO().updateAccount(account);

        }catch (SQLException e){
            System.out.println("updating account failed");
        }
    }
}

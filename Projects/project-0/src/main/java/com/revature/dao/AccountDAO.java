package com.revature.dao;


import com.revature.models.Account;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface AccountDAO {
    void addAccount(Account account) throws SQLException;
    void updateAccount(Account account) throws SQLException;
    void deleteAccount(int id) throws SQLException;
    Account getAccountbyAccountId(int accountID)throws SQLException;
    List<Account> getAllAccounts()throws SQLException;
    List<Account> getAccountsByCustomerId(int customerID) throws SQLException;
    Map<Integer,Account> getAccountsForTransfer(int accountIDforWithdral,int accountIDforDeposit)throws SQLException;
}

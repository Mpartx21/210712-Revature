package com.revature.dao;


import com.revature.models.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {
    void addAccount(Account account) throws SQLException;
    void updateAccount(Account account) throws SQLException;
    void deleteAccount(int id) throws SQLException;
    List<Account> getAccount() throws SQLException;
    Account accountByID(int id) throws SQLException;
}

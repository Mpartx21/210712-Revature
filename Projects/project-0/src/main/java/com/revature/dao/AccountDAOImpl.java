package com.revature.dao;


import com.revature.models.Account;
import com.revature.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    private static PreparedStatement preparedStatement = null;
    private static Connection connection = null;

    public AccountDAOImpl() {
        this.connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void addAccount(Account account) throws SQLException {
        String sql = "insert into account " +
                "(account_id,customer_id,account+_balance,account_type)" +
                " values (?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,account.getId());
        preparedStatement.setInt(2, account.getCustomerID());
        preparedStatement.setDouble(3, account.getBalance());
        preparedStatement.setString(4,account.getTypes().name());
        int count = preparedStatement.executeUpdate();
        if (count > 0){
            System.out.println("Account Added");
        }else {
            System.out.println("Ooops! Something went wrong");
        }
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        String sql = "update account set account_balance = ?, account_type = ? where account_id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, account.getBalance());
        preparedStatement.setString(2,account.getTypes().name());
        preparedStatement.setInt(3, account.getId());
        int count = preparedStatement.executeUpdate();
        if(count > 0) {
            System.out.println("Account updated");
        }else{
            System.out.println("Oops! something went wrong");
        }
    }

    @Override
    public void deleteAccount(int id) throws SQLException {
        String sql = "delete from account where account_id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if(count > 0) {
            System.out.println("Account deleted");
        }else{
            System.out.println("Oops! something went wrong");
        }
    }

    @Override
    public List<Account> getAccountsByCustomerId(int customerID) throws SQLException {
        List<Account> accounts = new ArrayList<>();
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "select * from account where customer_id = ?)";

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,customerID);
        ResultSet resultSet = preparedStatement.executeQuery(sql);

        while (resultSet.next()){
//            populate an employee object when it is iterated through
            int accountID = resultSet.findColumn("account_id");
            Double balance = resultSet.getDouble("account_balance");
            String types = resultSet.getString("account_type");
            Account account = new Account(accountID,customerID,balance,types);
            accounts.add(account);
        }
        return accounts;
    }

}

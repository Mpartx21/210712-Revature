package com.revature.dao;


import com.revature.models.Account;
import com.revature.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDAOImpl implements AccountDAO {

    private static PreparedStatement preparedStatement = null;
    private static Connection connection = null;

    public AccountDAOImpl() {
        this.connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void addAccount(Account account) throws SQLException {
        String sql = "insert into account " +
                "(account_balance,account_type,customer_id )" +
                " values (?,?,(select customer_id from customer where customer_id = ?))";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, account.getBalance());
        preparedStatement.setString(2,account.getTypes().getType());
        preparedStatement.setInt(3, account.getCustomerID());
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
        preparedStatement.setInt(3, account.getAccountID());
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
    public List<Account> getAllAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "select * from account";

        preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
//            populate an employee object when it is iterated through
            int accountID = resultSet.getInt("account_id");
            int customerID = resultSet.getInt("customer_id");
            Double balance = resultSet.getDouble("account_balance");
            String types = resultSet.getString("account_type");
            Account account = new Account(accountID,customerID,balance,types);
            accounts.add(account);
        }
        return accounts;    }

    @Override
    public List<Account> getAccountsByCustomerId(int customerID) throws SQLException {
        List<Account> accounts = new ArrayList<>();
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "select * from account where customer_id = ?";

         preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,customerID);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
//            populate an employee object when it is iterated through
            int accountID = resultSet.getInt("account_id");
            Double balance = resultSet.getDouble("account_balance");
            String types = resultSet.getString("account_type");
            Account account = new Account(accountID,customerID,balance,types);
            accounts.add(account);
        }
        return accounts;
    }

    @Override
    public Map<Integer, Account> getAccountsForTransfer(int accountIDforWithdrawal, int accountIDforDeposit) throws SQLException {
       Map<Integer,Account> accountTransfer =new HashMap<>();
        String sql = "select * from account where account_id = ? or account_id = ?";
        connection = ConnectionFactory.getInstance().getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,accountIDforDeposit);
        preparedStatement.setInt(2,accountIDforWithdrawal);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        while (resultSet1.next()){
            if(resultSet1.getInt("account_id") == accountIDforWithdrawal){
                int customerID = resultSet1.getInt("customer_id");
                double balance = resultSet1.getDouble("account_balance");
                String types = resultSet1.getString("account_type");
                accountTransfer.put(accountIDforWithdrawal,new Account(accountIDforWithdrawal,customerID,balance,types));
            }else{
                int customerID = resultSet1.getInt("customer_id");
                double balance = resultSet1.getDouble("account_balance");
                String types = resultSet1.getString("account_type");
                accountTransfer.put(accountIDforDeposit,new Account(accountIDforDeposit,customerID,balance,types));
            }
        }
        return accountTransfer;
    }

    @Override
    public Account getAccountbyAccountId(int accountID) throws SQLException {
        String sql = "select * from account where account_id = ?";
        connection = ConnectionFactory.getInstance().getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,accountID);
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
                int customerID = resultSet.getInt("customer_id");
                double balance = resultSet.getDouble("account_balance");
                String types = resultSet.getString("account_type");
                return new Account(accountID,customerID,balance,types);
        }
        return null;
    }
}

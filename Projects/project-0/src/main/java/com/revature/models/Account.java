package com.revature.models;

public class Account {
    private Integer accountID;
    private Integer customerID;
    private double balance;
    private AccountTypes types;


    public Account(int accountID, int customerID, Double balance, String types) {
        this.accountID = accountID;
        this.customerID = customerID;
        this.balance = balance;
        this.types = AccountTypes.getByType(types);
    }

    public AccountTypes getTypes() {
        return types;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public void setTypes(String types) {
        AccountTypes.valueOf(types);
    }

    public Account(int customerID, Double balance,AccountTypes type) {
        this.customerID = customerID;
        this.balance = balance;
        this.types = type;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Account ID= " + accountID +
                ",Account Types= " + types.toString().toUpperCase() +
                ",Balance= " + balance +
                '}';
    }
}

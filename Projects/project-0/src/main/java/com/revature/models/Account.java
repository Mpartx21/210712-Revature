package com.revature.models;

public class Account {
    private Integer id;
    private Integer customerID;
    private double balance;
    private AccountTypes types;

    public AccountTypes getTypes() {
        return types;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public void setTypes(AccountTypes types) {
        this.types = types;
    }

    public Account(int accountID, int customerID, Double balance, String type) {
        this.id = id;
        this.customerID = customerID;
        this.balance = balance;
        this.types.setType(type);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

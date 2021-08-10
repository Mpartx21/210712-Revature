package com.revature.models;

public class Account {
    private Integer id;
    private Integer customerID;
    private double balance;
    private AccountTypes types;

    public AccountTypes getTypes() {
        return types;
    }

    public void setTypes(AccountTypes types) {
        this.types = types;
    }

    public Account( double balance) {
        this.balance = balance;
        this.types = AccountTypes.CHECKING;
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

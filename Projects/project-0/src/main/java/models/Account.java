package models;

public class Account {
    private Integer id;
    private String account_name;
    private double balance;

    public Account(Integer id, String account_name, double balance) {
        this.id = id;
        this.account_name = account_name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

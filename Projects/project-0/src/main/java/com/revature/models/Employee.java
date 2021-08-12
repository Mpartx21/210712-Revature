package com.revature.models;

import java.util.Map;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String password;

    private static Map<Integer,Account> transfers;

    public Employee() {}

    public Map<Integer, Account> getTransfers() {
        return transfers;
    }

    public void setTransfers(Map<Integer, Account> transfers) {
        this.transfers = transfers;
    }

    public Employee(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Employee(int employeeId, String name, String email) {
        this.id = employeeId;
        this.name=name;
        this.email = email;
    }

    public Employee(int id, String name, String newEmail, String newPassword) {
        this.id=id;
        this.name=name;
        this.email = newEmail;
        this.password = newPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

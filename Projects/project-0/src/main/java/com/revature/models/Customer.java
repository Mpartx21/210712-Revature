package com.revature.models;

public class Customer {
    private Integer id;
    private String name;
    private String passWord;
    private String email;

    public Customer(Integer id, String name, String passWord, String email) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
        this.email = email;
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Customer(String name, String email, String passWord) {
        this.name = name;
        this.email = email;
        this.passWord = passWord;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

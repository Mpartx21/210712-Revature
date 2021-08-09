package com.revature.screen;

public abstract class Screen {
    private String name;

    public Screen(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void printScreen();
}

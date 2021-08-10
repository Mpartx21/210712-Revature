package com.revature.screen;

import static com.revature.Main.programManager;

public class AccountOptions extends Screen{
    public AccountOptions() {
        super("accountOptions");
    }

    @Override
    public void printScreen() {
        System.out.println("account options");
        System.out.println("1: Add Account");
        System.out.println("2: View Accounts");
        System.out.println("+-------------------+");

        switch (programManager.getScanner().nextLine()){
            case "1":
                programManager.getScreenNavigator().navigate("addAccount");
                break;
            case "2":
                programManager.getScreenNavigator().navigate("viewAccounts");
        }
    }
}

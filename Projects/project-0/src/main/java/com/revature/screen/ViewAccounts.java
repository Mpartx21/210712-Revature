package com.revature.screen;

import com.revature.dao.AccountDAOFactory;

public class ViewAccounts extends Screen{
    public ViewAccounts() {
        super("viewAccounts");
    }

    @Override
    public void printScreen() {
        try {
            AccountDAOFactory.getAccountDAO()
                    .getAccount()
                    .stream()
                    .forEach(account ->
                            System.out.println()        );

        }catch (Exception e ){

        }
    }
}

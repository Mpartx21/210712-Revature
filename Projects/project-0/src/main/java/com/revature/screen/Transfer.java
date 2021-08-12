package com.revature.screen;

import com.revature.exception.AuthenticateException;
import com.revature.service.AccountService;

import java.sql.SQLException;

import static com.revature.Main.programManager;

public class Transfer extends Screen{
    public Transfer() {
        super("transfer");
    }

    @Override
    public void printScreen(){
        System.out.println("Transferring");
        try{
            programManager.getEmployee().setTransfers(new AccountService().transfer());
            System.out.println("Transfer sent to Employee to Approve");
            programManager.getScreenNavigator().navigate("accountOptions");
        }catch (SQLException | AuthenticateException e){
            System.out.println("Issue with you transfer");
            programManager.getScreenNavigator().navigate("accountOptions");
        }
    }
}

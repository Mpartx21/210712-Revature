package com.revature.screen;

import com.revature.dao.AccountDAOFactory;
import com.revature.models.Account;
import com.revature.service.AccountService;

import java.sql.SQLException;

import static com.revature.Main.programManager;

public class EmployeeTransfers extends Screen {
    public EmployeeTransfers() {
        super("employeeTransfer");
    }

    @Override
    public void printScreen() {
        System.out.println("Employee Transfer Approvals");
        try {
            if (programManager.getEmployee().getTransfers() == null) {
                System.out.println("No Transfers Available Going Back");
                programManager.getScreenNavigator().navigate("employeeOptions");
            }
            transferApprove();


        }catch (SQLException e){
            System.out.println("Transfering Error");
            programManager.getScreenNavigator().navigate("employeeOptions");
        }
    }
    public void transferApprove() throws SQLException {
        Account deposit = null;
        Account withdrawal = null;
        double transfer = 0;
        for (Account account : programManager.getEmployee().getTransfers().values()) {
            Account account1 = AccountDAOFactory.getAccountDAO().getAccountbyAccountId(account.getAccountID());
            if (account.getBalance() > account1.getBalance()) {
                deposit = account;
                transfer = account.getBalance() - account1.getBalance();
            } else {
                withdrawal = account;
            }
        }
        System.out.println("Account ID: " + withdrawal.getAccountID() + " is withdrawing " + transfer +
                " Account ID :" + deposit.getAccountID());

        System.out.println("1: Approve\n" +
                "2: Deny");
        switch (programManager.getScanner().nextLine()) {
            case "1":
                new AccountService().withdrawal(AccountDAOFactory.getAccountDAO().getAccountbyAccountId(withdrawal.getAccountID()), transfer);
                new AccountService().deposit(AccountDAOFactory.getAccountDAO().getAccountbyAccountId(deposit.getAccountID()), transfer);
                System.out.println("Transfer completed");
                programManager.getScreenNavigator().navigate("employeeOptions");
                break;
            case "2":
                programManager.getEmployee().getTransfers().clear();
                System.out.println("Transfer denied");
                programManager.getScreenNavigator().navigate("employeeOptions");
            default:
                System.out.println("Try Again");
                programManager.getScreenNavigator().navigate("employeeTransfer");
        }
    }
}

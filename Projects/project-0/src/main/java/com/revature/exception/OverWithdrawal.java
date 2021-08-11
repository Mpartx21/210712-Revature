package com.revature.exception;

public class OverWithdrawal extends Exception{
    public OverWithdrawal() {
        super("Amount Exceeds current balance please try again");
    }
}

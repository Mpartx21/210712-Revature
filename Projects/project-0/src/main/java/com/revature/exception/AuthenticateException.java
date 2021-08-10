package com.revature.exception;

public class AuthenticateException extends Exception {
    public AuthenticateException(){
        super("Authenication failed");
    }

    public AuthenticateException(String message){
        super(message);
    }
}

package com.revature.exception;

public class DuplicateEmailException extends Exception{
    public DuplicateEmailException(){super("Email already in use please pick another");}
}

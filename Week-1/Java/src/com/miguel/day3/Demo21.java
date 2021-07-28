package com.miguel.day3;

import java.sql.SQLOutput;
class UserAlreadyLoggedInException extends Exception{

}
class Authentication{
    private boolean isLoggedIn = false;
    public void login(String email,String passWord) throws UserAlreadyLoggedInException {
        if(!isLoggedIn){
            if(email.equals("admin") && passWord.equals("123")){
                isLoggedIn = true;
                System.out.println("login successfully");
            }else {
                System.out.println("login failed! try again");
            }
        }else{
            throw new UserAlreadyLoggedInException();
        }
    }

}

public class Demo21 {
    public static void main(String[] args) {
        Authentication auth = new Authentication();
        try {
            auth.login("admin","123");

        }catch (UserAlreadyLoggedInException e){
            e.printStackTrace();
        }

        try{
            auth.login("admin","123");
        }catch(UserAlreadyLoggedInException e){
            e.printStackTrace();
            System.out.println("you done did it");
        }
    }
}

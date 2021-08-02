package com.miguel.assignments.calculator;

import java.util.Scanner;

public class Calculator {
    static boolean running = true;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        User user = new User();
        while (running) {
            System.out.println("Please choose first number");
            user.setFirstNumber();
            System.out.println("Please choose second number");
            user.setSecondNumber();

            System.out.println("Please choose you operation\n" +
                    "-add\n" +
                    "-sub\n" +
                    "-multi\n" +
                    "-div\n" +
                    "-quit");
            switch (scanner.nextLine()){
                case"add":
                    System.out.println("Answer: " +user.addition(user.getFirstNumber(),user.getSecondNumber()));
                    break;
                case"sub":
                    System.out.println("Answer: " +user.subtractions(user.getFirstNumber(),user.getSecondNumber()));
                    break;
                case"multi":
                    System.out.println("Answer: " +user.multiplication(user.getFirstNumber(),user.getSecondNumber()));
                    break;
                case"div":
                    System.out.println("Answer: " +user.division(user.getFirstNumber(),user.getSecondNumber()));
                    break;
                case"quit":
                    running =false;
                    break;
                default:
                    System.out.println("try again");
            }

        }
    }


}

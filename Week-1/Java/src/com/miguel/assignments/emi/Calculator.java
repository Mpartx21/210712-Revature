package com.miguel.assignments.emi;

import java.util.Scanner;

public class Calculator {
    static boolean running = true;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        User user = new User();

        while (running){
            System.out.println("Enter Loan Amount");
            user.setLoanAmount(scanner.nextFloat());

            System.out.println("Enter Rate Of Interest");
        }
    }
}

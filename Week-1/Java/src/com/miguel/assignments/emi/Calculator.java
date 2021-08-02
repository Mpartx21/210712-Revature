package com.miguel.assignments.emi;

import java.util.Scanner;

public class Calculator {
    static boolean running = true;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        User user = new User();

        do{
            System.out.println("Enter Loan Amount");
            user.setLoanAmount(scanner.nextDouble());

            System.out.println("Enter Rate Of Interest");
            user.setRateOfInterest(scanner.nextDouble());

            System.out.println("Enter Total Years Of Payment");
            user.setYears(scanner.nextDouble());

            double emi =  (user.getLoanAmount() * user.getRateOfInterest() *
                    Math.pow(1 +user.getRateOfInterest(), user.getYears())
                    /(Math.pow(1 + user.getRateOfInterest(),user.getYears())-1));

            System.out.println("Your Equated Monthly Installment is "
                    + emi);

            System.out.println("Try Again\nyes / no");
            String i = scanner.next();
            switch (i){
                case "yes":
                    break;
                case"no":
                    running = false;
                    break;
                default:
                    System.out.println("Going Again Anyway");
            }
        }while (running);
    }
}

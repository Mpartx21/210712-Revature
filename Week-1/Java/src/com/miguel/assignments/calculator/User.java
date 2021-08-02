package com.miguel.assignments.calculator;

import java.util.Scanner;

public class User {
    private float firstNumber;
    private float secondNumber;


    public float getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber() {
        Scanner scanner = new Scanner(System.in);
        this.firstNumber = scanner.nextFloat();
    }

    public float getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber() {
        Scanner scanner = new Scanner(System.in);
        this.secondNumber = scanner.nextFloat();
    }

    public float addition(float firstNumber, float secondNumber){
        return firstNumber + secondNumber;
    }

    public float subtractions(float firstNumber,float secondNumber){
        return firstNumber - secondNumber;
    }

    public float multiplication(float firstNumber,float secondNumber){
        return firstNumber * secondNumber;
    }

    public float division(float firstNumber,float secondNumber){
        return firstNumber / secondNumber;
    }
}

package com.miguel.day7;

class Calculator{
    public boolean areEqual(int a,int b){
        if (a == b)
            return true;
        else
            return false;
    }
}

public class Demo1 {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        boolean result = cal.areEqual(10,20);
        if (result)
            System.out.println("Numbers are Equal");
        else
            System.out.println("Numbers are not Equal");
    }
}

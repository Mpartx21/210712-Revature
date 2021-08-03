package com.miguel.day7;

class Employee{

    String name;

    public <T> Employee(T name){
        this.name = name.toString();
        System.out.println(this.name);
    }

}

public class Demo6 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Mark");
        Employee emp2 = new Employee(123);
    }
}

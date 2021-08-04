package com.miguel.day7;

import java.util.Arrays;

class GenericMethodDemo{

    public static <E> void printArray(E[] elements){
        for(E element: elements){
            System.out.println(element);
        }
        System.out.println("**************");
    }

}

interface GenericInterface{
    static <E> void printArrays(E[] elements){}
}

public class Demo5 {
    public static void main(String[] args) {
        Integer[] intArray = { 10,20,30,40 };
        Character[] charArray = { 'A', 'B', 'C', 'D' };

        GenericMethodDemo.printArray(intArray);
        GenericMethodDemo.printArray(charArray);

        Arrays.stream(intArray).forEach(System.out::println);
        System.out.println("**************");
        Arrays.stream(charArray).forEach(System.out::println);
        System.out.println("**************");
        Arrays.stream(intArray).forEach(num -> {
            System.out.println(num);
        });

    }
}

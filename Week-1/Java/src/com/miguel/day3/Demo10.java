package com.miguel.day3;

import java.util.Arrays;

public class Demo10 {
    public static void main(String[] args) {
        String message = "Hello, welcome to java";
        String[] result = message.split("w");
        System.out.println(Arrays.toString(result));
    }
}

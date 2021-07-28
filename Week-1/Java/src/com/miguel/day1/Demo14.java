package com.miguel.day1;

public class Demo14 {
    public static void main(String[] args) {
        for(int i=1;i<=100;i++){
            if(i==5){
                continue;
                // will skip the rest statement
            }
            if(i<99 || i ==4){
                continue;
            }
            System.out.println(i);
        }


    }
}

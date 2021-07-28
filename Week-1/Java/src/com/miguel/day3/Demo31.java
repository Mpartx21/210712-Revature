package com.miguel.day3;

import java.io.FileOutputStream;

public class Demo31 {
    public static void main(String[] args) {
        try(FileOutputStream stream = new FileOutputStream("E:\\projects\\Revature\\210712-Revature\\Week-1\\Java\\src\\com\\miguel\\day3\\data.txt"))    {
            String data = "Hello World";

            byte[] arr = data.getBytes();

            stream.write(arr);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Resource are closed");
    }
}

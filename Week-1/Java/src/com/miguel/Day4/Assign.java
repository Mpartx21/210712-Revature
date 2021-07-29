package com.miguel.Day4;

import java.util.*;
import java.util.function.BiConsumer;

public class Assign {
    public static void main(String[] args) {

//      1.
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Green");
        System.out.println("The colors have been made" +colors.toString());

//      2.
        System.out.println("\nIterating and saying the color names");
        for (String color: colors) {
            System.out.println(color);
        }

//      3.
        colors.add(0,"Pink");

//      4.
        String thisColor = colors.get(0);
        System.out.println("\nNew color added is "+thisColor);

//      5.
        String anotherColor = "Purple";
        colors.set(0,anotherColor);
        System.out.println("\nPink was replaced with Purple\n");

//      6.
        colors.remove(2);

//      7.
        System.out.println("Does Pink exist :" + colors.contains(thisColor));

//      8.
        System.out.println("\nUnsorted List");
        for (String color: colors) {

            System.out.println( color);
        }
        Collections.sort(colors);
        System.out.println("\nSorted List");
//        for (String color: colors) {
//            System.out.println(color);
//        }
        colors.forEach(color ->{
            System.out.println(color);
        });

//      9.
        ArrayList<String> anotherArrayList = (ArrayList<String>) colors.clone();
//                new ArrayList<>(colors);
//        ArrayList anotherArrayList = colors;
//        anotherArrayList.addAll(colors);
        System.out.println("\nThe original list " + colors.toString()+"\n"
                            +"The copy " + anotherArrayList.toString()+"\n");

//      10.
        Collections.shuffle(colors);
        System.out.println("Shuffled List");
        colors.forEach(System.out::println);


//      11.
        Collections.reverse(colors);
        System.out.println("\nReversed List");
        colors.forEach(System.out::println);

//      12.
        List<String> extractedColors = colors.subList(1,3);
        System.out.println("\nExtracted List");
        extractedColors.forEach(System.out::println);

//      13.
        System.out.println("\nBefore the Swap:");
        colors.forEach(System.out::println);
        Collections.swap(colors,0,3);
        System.out.println("\nAfter the swap:");
        colors.forEach(System.out::println);
        //Maps
//      1.
        Map<Integer,String> colorMap = new HashMap<>();
        for(int i =0;i<4;i++){
            colorMap.put(i,colors.get(i));
        }

        System.out.println("\n The key and values for my ");

        colorMap.forEach((integer, color) -> {
            System.out.println(integer + " " + color );
        });

//      2.
        System.out.println("\nThe size of the map: " +colorMap.size());
          
//      3.
        HashMap anotherMap = new HashMap(colorMap);
        System.out.println("\nThe original list " + colorMap.toString()+"\n"
                +"The copy " + anotherMap.toString()+"\n");
    }

}


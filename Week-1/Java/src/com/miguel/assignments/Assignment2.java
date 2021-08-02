package com.miguel.assignments;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Assignment2 {
    public static void main(String[] args) {
//    # Linked List
//1. Write a Java program to append the specified element to the end of a linked list.
        LinkedList<String> myLinkedList = new LinkedList<>();
        myLinkedList.add("one");
        myLinkedList.add("two");
        myLinkedList.add("three");
        myLinkedList.add("four");
        myLinkedList.add("five");
        myLinkedList.add("six\n");

//2. Write a Java program to iterate through all elements in a linked list.
        System.out.println("\nIterating through all the elements");
        myLinkedList.forEach(System.out::println);
//3. Write a Java program to iterate through all elements in a linked list starting at the specified position.

        System.out.println("\nIterating through all the elements starting at 2");
        Iterator<String> i = myLinkedList.listIterator(2);
        while(i.hasNext()){
            System.out.println(i.next());
        }
//4. Write a Java program to iterate a linked list in reverse order.
        i = myLinkedList.descendingIterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
// 5. Write a Java program to insert the specified element at the specified position in the linked list.
        myLinkedList.add(0,"zero");
        myLinkedList.forEach(System.out::println);
//# HashSet
//1. Write a Java program to append the specified element to the end of a hash set.
        HashSet<String> myHashset = new HashSet<>();
        myHashset.add("one");
        myHashset.add("two");
        myHashset.add("three");
        myHashset.add("four");
        myHashset.add("five");
        myHashset.add("six\n");
//2. Write a Java program to iterate through all elements in a hash list.
        System.out.println("\nIterating through all the elements");
        myHashset.forEach(System.out::println);
//3. Write a Java program to get the number of elements in a hash set.
        System.out.println("The number of elements in myHashSet:"+myHashset.size()+"\n");
//4. Write a Java program to empty an hash set.
        System.out.println("Before: "+myHashset.toString());
        myHashset.clear();
        System.out.println("After: "+ myHashset.toString());
//# TreeSet
// Write a Java program to create a new tree set, add some colors (string) and print out the tree set.
        TreeSet<String> myTreeSet = new TreeSet<>();
        myTreeSet.add("Blue");
        myTreeSet.add("Red");
        myTreeSet.add("Green");
        myTreeSet.add("Yellow");
        myTreeSet.add("White");
        myTreeSet.add("Black");
        myTreeSet.forEach(System.out::println);
//2. Write a Java program to iterate through all elements in a tree set.
        System.out.println("\nIterating through all the elements");
        for (String color:myTreeSet){
            System.out.println(color);
        }
//3. Write a Java program to add all the elements of a specified tree set to another tree set.
        TreeSet<String> myOtherTreeSet   = (TreeSet<String>)myTreeSet.clone();
        System.out.println("\nThe original list " + myTreeSet.toString()+"\n"
                +"The copy " + myOtherTreeSet.toString()+"\n");
//4. Write a Java program to create a reverse order view of the elements contained in a given tree set.
        i = myTreeSet.descendingIterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
//5. Write a Java program to get the first and last elements in a tree set
        String firstInTree = myTreeSet.first();

        String lastInTree = myTreeSet.last();
        System.out.println("\nFirst In Tree: "+firstInTree
                            +"\nLast In Tree: "+lastInTree);

    }
}

package com.miguel.day1;

class Book {
    public String title;
    public String author;
    public int price;

    public Book() {
    }

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void printBookTitle(){
        System.out.println(this.title);
    }

    public void printInfo() {
        System.out.println("Book: Title=" + title + ", Author=" + author + ", Price=" + price);
    }
}

public class Demo15 {
    public static void main(String[] args) {
        Book book1 = new Book("Java","Author 1",100);
//        book1.title = "Java";
//        book1.author = "Author 1";
//        book1.price = 100;

        Book book2 = new Book("Angular","Author 2",200);
//        book2.title = "Angular";
//        book2.author = "Author 2";
//        book2.price = 200;

        book1.printInfo();
        book2.printInfo();
        book1.printBookTitle();
        book2.printBookTitle();
    }
}

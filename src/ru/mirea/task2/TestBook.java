package ru.mirea.task2;

import java.lang.*;
public class TestBook {
    public static void main(String[] args) {
        Book b1 = new Book("Test1", 456);
        Book b2 = new Book("Test2", 39);
        System.out.println(b1);
        System.out.println(b1.getName());
        System.out.println(b2);
        b2.setPage(100);
        System.out.println(b2.getPage());
    }
}

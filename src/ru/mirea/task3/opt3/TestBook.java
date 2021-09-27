package ru.mirea.task3.opt3;

import java.lang.*;
public class TestBook {
    public static void main(String[] args) {
        Book b1 = new Book("Peace of World", 456, "Kravchenko", "1847");
        Book b2 = new Book("Monkey's Journey", 39, "Martinov", "2007");
        System.out.println(b1);
        System.out.println(b1.getName());
        System.out.println(b2);
        b2.setPage(100);
        System.out.println(b2.getPage());
    }
}

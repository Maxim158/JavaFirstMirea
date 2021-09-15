package ru.mirea.task2;

import java.lang.*;
public class Book {
    private int pageCount;
    private String name;

    public Book(String name, int pageCount) {
        this.name = name;
        this.pageCount = pageCount;
    }

    public int getPage() {
        return this.pageCount;
    }
    public String getName() {
        return this.name;
    }
    public void setPage(int pageCount) {
        this.pageCount = pageCount;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return this.name +", the number of pages in it "+ this.pageCount;
    }
}

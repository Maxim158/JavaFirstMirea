package ru.mirea.task3.opt3;

import java.lang.*;
public class Book {
    private int pageCount;
    private String name;
    private String AuthorName;
    private String YearOfPublication;

    public Book(String name, int pageCount, String AuthorName, String YearOfPublication) {
        this.name = name;
        this.AuthorName = AuthorName;
        this.YearOfPublication = YearOfPublication;
        this.pageCount = pageCount;
    }

    public int getPage() {
        return this.pageCount;
    }
    public String getName() {
        return this.name;
    }
    public String getAuthor() {return this.AuthorName;};
    public String getYear() {return this.YearOfPublication;};
    public void setPage(int pageCount) {
        this.pageCount = pageCount;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String Author) {this.AuthorName = Author;}
    public void setYear(String Year) {this.YearOfPublication = Year;}
    public String toString(){return this.name + "was wrote in " +YearOfPublication + " by " + AuthorName + "it has "+ this.pageCount + " pages";
    }
}

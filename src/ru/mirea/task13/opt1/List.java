package ru.mirea.task13.opt1;

import java.util.ArrayList;

public class List {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Sun");
        list.add("Moon");
        list.add("Mars");
        list.add(1,"Earth");
        System.out.printf("List contains %d elements \n", list.size());
        for(String s : list)
        {
            System.out.println(s);
        }
        if (list.contains("Sun")){
            System.out.println("list contains Sun");
        }
        else {
            System.out.println("List doesn't contains Sun");
        }
        if (list.contains("Io")){
            System.out.println("list contains Io");
        }
        else{
            System.out.println("List doesn't contains Io");
        }
        list.remove("Sun");
        System.out.printf("List contains %d elements ) \n", list.size());
        for(String s : list)
        {
            System.out.println(s);
        }
        System.out.println(list.contains("Mars"));
        System.out.println(list.contains("Io"));
        list.clear();
        System.out.printf("List contains %d elements ) \n", list.size());
    }
}
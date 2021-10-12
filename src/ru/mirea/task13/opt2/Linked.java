package ru.mirea.task13.opt2;

import java.util.LinkedList;

public class Linked {
    public static void main(String[] args){
        LinkedList<String> link = new LinkedList<String>();
        link.add("Sun");
        link.add("Moon");
        link.add("Mars");
        link.add(1,"Earth");
        String str = new String("Io");
        link.add(0,str);
        System.out.printf("List contains %d elements \n", link.size());
        for(String s : link)
        {
            System.out.println(s);
        }
        if (link.contains("Sun")){
            System.out.println("list contains Sun");
        }
        else {
            System.out.println("List doesn't contains Sun");
        }
        link.removeFirst();
        link.removeLast();
        for(String s : link)
        {
            System.out.println(s);
        }
        System.out.println("Does this link consist Earth? "+link.contains("Earth"));
        System.out.println("First element of LinkedList: "+link.peekFirst());
        System.out.println("Last element of LinkedList: "+link.peekLast());
    }
}

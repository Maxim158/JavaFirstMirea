package ru.mirea.task3.opt2;

public class TestHuman {
    public static void main(String[] args)
    {
        Human h1 = new Human(21,"Grigorii",'M');
        Head h2 = new Head(20, "Arnold", 'M',34,true);
        Leg h3 = new Leg(12,"Madat", 'M',10,false);
        Hand h4 = new Hand(12,"Vanya", 'M',10,true);
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);
    }
}
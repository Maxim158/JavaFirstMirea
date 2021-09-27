package ru.mirea.task3.opt2;

public class Head extends Human {
    double radius;
    boolean bald;
    public Head(int age, String name, char g, double radius, boolean bald){
        super( age,  name,  g);
        this.radius = radius;
        this.bald = bald;
    }

    public String toString(){
        return "Radius of head: " + this.radius + ", Bald? : " + this.bald;
    }
}
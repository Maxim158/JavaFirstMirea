package ru.mirea.task3.opt2;

public class Leg extends Human{
    double length;
    boolean exists;
    public Leg(int age, String name, char g, double length, boolean exists){
        super( age,  name,  g);
        this.length = length;
        this.exists = exists;
    }

    public String toString(){
        return "Length of leg: " + this.length + ", Exists? : " + this.exists;
    }
}

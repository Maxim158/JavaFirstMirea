package ru.mirea.task3.opt2;

public class Human {
    int age;
    String name;
    char g;
    public  Human(int age, String name, char g){
        this.age=age;
        this.name=name;
        this.g=g;
    }
    public String toString(){
        return "Name of this body: " + this.name + " it's gender " + this.g +", it's age "+this.age;
    }
}
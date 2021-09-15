package ru.mirea.task5;

import java.lang.*;
public abstract class Dish {
    private String name;

    public String getName() {return name;}
    public Dish(String name) {this.name = name;}
    public abstract void DisplayInfo();
}

class Fork extends Dish {
    private int forkTeeth;

    public Fork(String name, int forkTeeth) {
        super(name);
        this.forkTeeth = forkTeeth;
    }
    public void DisplayInfo() {
        System.out.println("I'm a Fork! I'm a Fork! My name is " + super.getName() + " I have " +forkTeeth+" Teeth!" );
    }
}

class Spoon extends Dish {
    private String sizeOfSpoon;

    public Spoon(String name, String sizeOfSpoon) {
        super(name);
        this.sizeOfSpoon = sizeOfSpoon;
    }
    public void DisplayInfo() {
        System.out.println("Get over the anvil! My name is " + super.getName() +" I'm a " + sizeOfSpoon + " spoon.");
    }
}

class Plate extends Dish {
    private String color;
    private double diameter;
    private double depth;

    public Plate(String name, String color, double diameter, double depth) {
        super(name);
        this.color = color;
        this.depth = depth;
        this.diameter = diameter;
    }
    public void DisplayInfo() {
        System.out.println("I believe i can fly! My name is " + super.getName() + " my color is " + color +", my diameter is " + diameter + " and my depth is "+ depth + ".");
    }
}
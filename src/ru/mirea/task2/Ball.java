package ru.mirea.task2;

import java.lang.*;
public class Ball {
    private String color;
    private double radius;

    public Ball(String color , double radius) {
        this.color = color;
        this.radius = radius;
    }
    public Ball(double radius) {
        this.color = "Unidentified";
        this.radius = radius ;
    }
    public String getColor() {
        return this.color;
    }
    public double getRadius() {
        return this.radius;
    }
    public void setColor(String color) {
         this.color = color;
    }
    public void setRadius(double radius) {
         this.radius = radius;
    }
    public String toString(){
        return this.color +", his radius is "+ this.radius;
    }
}

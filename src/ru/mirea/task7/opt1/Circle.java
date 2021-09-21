package ru.mirea.task7.opt1;

public class Circle extends Shape {
    protected double radius;

    public Circle() {
        super();
        this.filled = false;
        this.color = "blue";
        radius = 1;
    };
    public Circle(double radius) {
        super();
        this.filled = false;
        this.color = "blue";
        this.radius = radius; }
    public Circle(double radius, String color, Boolean filled) {
        super();
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public double getRadius() {return this.radius;}
    public void setRadius(double radius) {this.radius = radius;}
    public double getArea() {return Math.PI * radius * radius;}
    public double getPerimeter() {return 2 * Math.PI * radius;}
    public String toString() {return "This " + this.color + " Circle with radius — " + this.radius + " have Area: " + getArea() + " and Perimeter: " + getPerimeter() + ".";}


}

package ru.mirea.task7.opt1;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {
        super();
        this.filled = false;
        this.color = "blue";
        this.width = 1;
        this.length = 1;
    }
    public Rectangle(double width, double length) {
        super();
        this.filled = false;
        this.color = "blue";
        this.width = width;
        this.length = length;
    }
    public Rectangle(double width, double length, String color, Boolean filled) {
        super();
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    public double getWidth() {return this.width;}
    public void setWidth(double width) {this.width = width;}
    public double getLength() {return this.length;}
    public void setLength() {this.length = length;}
    public double getArea() {return width * length;}
    public double getPerimeter() {return 2 * (width + length);}
    public String toString() {return "This " + this.color + " rectangle with width — " + this.width + " and length — " + this.length + " have Area: " + getArea() + " and Perimeter: " + getPerimeter() + ".";}
}

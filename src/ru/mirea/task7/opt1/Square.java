package ru.mirea.task7.opt1;

public class Square extends Rectangle {
    double side;
    public Square() {
        super();
        this.filled = false;
        this.color = "blue";
        this.side = 1;
    }
    public Square(double side) {
        super();
        this.filled = false;
        this.color = "blue";
        this.side = side;
    }
    public Square(double side, String color, Boolean filled) {
        super();
        this.side = side;
        this.color = color;
        this.filled = filled;
    }

    public double getSide() {return this.side;}
    public void setSide(double side) {this.side = side;}
    public double getArea() {return side * side;}
    public double getPerimeter() {return 4 * side;}
    public String toString() {return "This " + this.color + " square with side — " + this.side + " have Area: " + getArea() + " and Perimeter: " + getPerimeter() + ".";}
}
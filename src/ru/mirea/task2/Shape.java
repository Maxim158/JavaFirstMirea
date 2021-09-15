package ru.mirea.task2;

public class Shape {
    String Type;
    String Color;
    Shape(String Type, String Color) {
        this.Type = Type;
        this.Color = Color;
    }
    public void setType(String Type) {this.Type = Type;};
    public void setColor(String Color) {this.Color = Color;}
    public String getType() {return this.Type;}
    public String getColor() { return this.Color;}
    public String toString() {return "Type: " + Type + ", Color: " + Color;}
}

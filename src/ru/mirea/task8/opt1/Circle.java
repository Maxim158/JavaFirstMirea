package ru.mirea.task8.opt1;

import java.awt.*;

public class Circle extends Shape{
    double radius;
    public void Circle () {
        this.type = "Circle";
    }
        public void paintComponent(Graphics g) {
            g.setColor(new Color(this.r,this.g,this.b));
            this.r = (int) (Math.random() * 255);
            this.g = (int) (Math.random() * 255);
            this.b = (int) (Math.random() * 255);
            g.fillOval(90,20,100,100);
        }
}
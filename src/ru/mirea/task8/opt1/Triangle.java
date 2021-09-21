package ru.mirea.task8.opt1;

import java.awt.*;

public class Triangle extends Shape{
    double radius;
    public void Triangle () {
        this.type = "Rectangle";
    }
        public void paintComponent(Graphics g) {
        int [] x = {140,190,90};
        int [] y = {30,130,130};
        this.r = (int) (Math.random() * 255);
        this.g = (int) (Math.random() * 255);
        this.b = (int) (Math.random() * 255);
        g.setColor(new Color(this.r,this.g,this.b));
        g.fillPolygon(x, y, 3);
    }
}
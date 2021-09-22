package ru.mirea.task7.opt2;

public class TestMovable {
    public static void main(String[] args) {
        read(new MovablePoint(1,1,10,10));
        read(new MovableCircle(5,5,10,13,11));
        read(new MovableRectangle(14,2,20,10,4,5));
    }
    public static void read(Movable element) {
        System.out.println(element);
        element.moveDown();
        element.moveRight();
        System.out.println(element);
    }
}

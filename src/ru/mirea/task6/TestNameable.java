package ru.mirea.task6;

import java.lang.*;
public class TestNameable {
    public static void main(String[] args) {
        read(new Planet("Sun"));
        read(new Car("Boeing"));
        read(new Animal("You"));
    }

    static void read(Nameable n) {
        n.getName();
    }
}
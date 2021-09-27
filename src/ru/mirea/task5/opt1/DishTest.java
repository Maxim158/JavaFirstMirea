package ru.mirea.task5.opt1;

import java.lang.*;
public class DishTest {
    public static void main(String[] args) {
        Fork dish1 = new Fork("First", 4);
        Spoon dish2 = new Spoon( "Second", "tea");
        Plate dish3 = new Plate("Third", "Red", 10, 1);
        dish1.DisplayInfo();
        dish2.DisplayInfo();
        dish3.DisplayInfo();
    }
}


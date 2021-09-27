package ru.mirea.task6.opt2;


public class TestPriceable {
    public static void main(String[] args) {
            read(new Car(350000));
            read(new Dish(500));
            read(new Phone(10000));
        }

        static void read(Priceable n) {
            System.out.println("Price: " + n.getPrice());
        }
    }

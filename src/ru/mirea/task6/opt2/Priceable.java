package ru.mirea.task6.opt2;

import ru.mirea.task6.opt1.Nameable;

public interface Priceable {
    double getPrice();
}

class Car implements Priceable {
    private double price;

    Car(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Dish implements Priceable {
    private double price;

    Dish(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
class Phone implements Priceable {
    private double price;

    Phone(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
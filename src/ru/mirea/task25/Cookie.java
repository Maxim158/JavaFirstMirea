package ru.mirea.task25;

public class Cookie implements Decorator {
    private String label;
    private double price;

    public Cookie(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getLabel() {
        return this.label;
    }
}
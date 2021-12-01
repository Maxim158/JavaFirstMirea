package ru.mirea.task25;

public class Main {
    public static void main(String[] args) {
        double cost = 0;
        Decorator latte = new Coffee("Latte", 130);
        Decorator choc = new Cookie("Chocolate", 80);
        Decorator sign = new Sign(latte);
        Decorator extra = new ExtraSize(choc);
        cost += sign.getPrice();
        cost += extra.getPrice();
        System.out.println(cost);
    }
}

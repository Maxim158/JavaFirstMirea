package ru.mirea.task26;

public class Main {
    public static void main(String[] args) {
        Bulb bulb = new Bulb();
        Computer computer = new Computer();
        Tesla tesla = new Tesla();

        bulb.voltage();
        computer.voltage();
        tesla.voltage();
    }
}

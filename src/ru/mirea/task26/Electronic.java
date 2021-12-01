package ru.mirea.task26;

public class Electronic {
    VoltageStrategy voltageStrategy;

    public void turnOn() {
        System.out.println("Включено");
    }

    public void turnOff() {
        System.out.println("Выключено");
    }

    public void voltage() {
        voltageStrategy.voltage();
    }
}

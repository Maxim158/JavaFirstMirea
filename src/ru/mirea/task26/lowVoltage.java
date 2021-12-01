package ru.mirea.task26;

public class lowVoltage implements VoltageStrategy {
    public void voltage() {
        System.out.println("Только низкое напряжение");
    }
}

package ru.mirea.task26;

public class midVoltage implements VoltageStrategy {
    public void voltage() {
        System.out.println("Только низкое/среднее напряжение");
    }
}

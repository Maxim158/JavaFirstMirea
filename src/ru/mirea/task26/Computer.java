package ru.mirea.task26;

public class Computer extends Electronic{

    public Computer() {
        this.voltageStrategy = new midVoltage();
    }
}

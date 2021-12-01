package ru.mirea.task26;

public class Bulb extends Electronic {

    public Bulb() {
        this.voltageStrategy = new lowVoltage();
    }
}

package ru.mirea.task26;

public class Tesla extends Electronic {

    public Tesla() {
        this.voltageStrategy = new highVoltage();
    }
}

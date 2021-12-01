package ru.mirea.task25;

public class Sign extends DecoratorOption {
    public Sign(Decorator decorator) {
        super(decorator, "Signed", 200);
    }
}
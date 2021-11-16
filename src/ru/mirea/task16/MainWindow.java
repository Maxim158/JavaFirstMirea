package ru.mirea.task16;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(910, 760);
        setResizable(false);
        setLocationRelativeTo(null);
        add(new SnakeGame(this));
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
    }
}

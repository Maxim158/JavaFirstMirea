package ru.mirea.task16;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    public MainWindow(SavedGame save) {
        setTitle("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(910, 760);
        setResizable(false);
        setLocationRelativeTo(null);
        add(new SnakeGame(this, save));
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SavedGame save = (SavedGame) objectInputStream.readObject();
        MainWindow window = new MainWindow(save);
    }
}

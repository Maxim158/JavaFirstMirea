package ru.mirea.task8.opt2;

import javax.swing.*;
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Window w = new Window();
                w.setVisible(true);
            }
        });
    }
}

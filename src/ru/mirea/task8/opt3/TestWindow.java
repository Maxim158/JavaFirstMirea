package ru.mirea.task8.opt3;

import ru.mirea.task8.opt2.Window;

import java.lang.*;
import javax.swing.*;
import java.awt.*;

public class TestWindow {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setSize(300, 300);
        frame.setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int) ((dimension.getWidth() - frame.getWidth()) / 2), (int) ((dimension.getHeight() - frame.getHeight()) / 2));
        frame.setVisible(true);
        JLabel picture = new JLabel("", JLabel.CENTER);
        frame.add(picture);

        while(true) {
            frame.setBackground(Color.white);
            picture.setIcon(new ImageIcon("C:\\Users\\IVC1-5\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task8\\opt3\\pic1.png","test"));
            Thread.sleep(1000);
            frame.setBackground(Color.white);
            picture.setIcon(new ImageIcon("C:\\Users\\IVC1-5\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task8\\opt3\\pic2.png","test"));
            Thread.sleep(1000);
            frame.setBackground(Color.white);
            picture.setIcon(new ImageIcon("C:\\Users\\IVC1-5\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task8\\opt3\\pic3.png","test"));
            Thread.sleep(1000);
        }
    }
}
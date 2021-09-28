package ru.mirea.task8.opt2;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {

    private JLabel pictureLabel;
    private Container controls;

    public Window() {
        super("window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.setSize(1000, 500);
        this.centreWindow(this);
        this.startWindow();
    }

    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    private void startWindow() {
        controls = new Container();
        controls = getContentPane();
        controls.setLayout(new FlowLayout());
        pictureLabel = new JLabel(new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task8\\opt2\\Picture.jpg","test"));
        controls.add(pictureLabel);
    }
}
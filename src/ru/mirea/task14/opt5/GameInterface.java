package ru.mirea.task14.opt5;

import ru.mirea.task14.opt1.GameStack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameInterface extends JFrame {

    public GameInterface(){
        super("DrunkMan");
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel drunkMan = new JLabel("DrunkMan");
        drunkMan.setFont(new Font("Serif", Font.BOLD, 24));
        drunkMan.setBounds(140,20,200,20);
        JTextField first = new JTextField();
        first.setBounds(50,100,100,30);
        JLabel firstText = new JLabel("First Player");
        firstText.setBounds(50,70,100,30);
        JTextField second = new JTextField();
        second.setBounds(250,100,100,30);
        JLabel secondText = new JLabel("Second Player");
        secondText.setBounds(250,70,100,30);
        JPanel p = new JPanel();
        JButton play = new JButton("Play!");
        play.setBounds(150,150,100,60);
        p.setLayout(null);
        p.add(drunkMan);
        p.add(first);
        p.add(firstText);
        p.add(second);
        p.add(secondText);
        p.add(play);

        getContentPane().add(p);

        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    String x1 = first.getText().trim();
                    String x2 = second.getText().trim();
                    if(x1.length() == x2.length() && x1.length() != 0) {
                        JOptionPane.showMessageDialog(null, new GameStack(x1, x2).play(), "DrunkMan", JOptionPane.INFORMATION_MESSAGE);
                        first.setText("");
                        second.setText("");
                    }
                    else {
                        throw new Exception("Incorrect Input");
                    }
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, a.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public static void main(String[] args) {
        new GameInterface().setVisible(true);
    }
}
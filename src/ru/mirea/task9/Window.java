package ru.mirea.task9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {
    int goalAC = 0;
    int goalRM = 0;
    public Window() {
        JFrame frame = new JFrame("Football");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setSize(600, 350);
        JLabel labelResult = new JLabel("Result: " + goalAC + " x " + goalRM);
        labelResult.setBounds(250,30,100,10);
        JLabel labelLast = new JLabel("Last Scorer: N/A");
        labelLast.setBounds(250,50,200,10);
        JLabel labelWinner = new JLabel("Winner: N/A");
        labelWinner.setBounds(250,70,200,10);
        JButton buttonAC = new JButton("AC Milan");
        JButton buttonRM = new JButton("Real Madrid");
        JButton buttonRST = new JButton("RESET");
        buttonRM.setBounds(310,250,150,30);
        buttonAC.setBounds(140,250,150,30);
        buttonRST.setBounds(30,30,100,30);
        frame.setLayout(null);
        frame.add(buttonAC);
        frame.add(buttonRM);
        frame.add(buttonRST);
        frame.add(labelResult);
        frame.add(labelLast);
        frame.add(labelWinner);
        frame.setVisible(true); buttonAC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateAC(frame, labelResult, labelLast, labelWinner);
            }
        });

        buttonRM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateRM(frame, labelResult, labelLast, labelWinner);
            }
        });

        buttonRST.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateRST(frame, labelResult, labelLast, labelWinner);
            }
        });
    }

    public void calculateAC(JFrame frame, JLabel label, JLabel label2, JLabel label3) {
        goalAC++;
        label.setText("Result: " + goalAC + " x " + goalRM);
        label2.setText("Last Scorer: AC Milan");
        if (goalAC > goalRM) {
            label3.setText("Winner: AC Milan");
        }
        else {
              if(goalRM > goalAC) {
                  label3.setText("Winner: Real Madrid");
            }
              else {
                  label3.setText("Winner: Draw");
              }
        }
    }
    public void calculateRM(JFrame frame, JLabel label, JLabel label2, JLabel label3) {
        goalRM++;
        label.setText("Result: " + goalAC + " x " + goalRM);
        label2.setText("Last Scorer: Real Madrid");
        if (goalAC > goalRM) {
            label3.setText("Winner: AC Milan");
        }
        else {
            if(goalRM > goalAC) {
                label3.setText("Winner: Real Madrid");
            }
            else {
                label3.setText("Winner: Draw");
            }
        }
    }
    public void calculateRST(JFrame frame, JLabel label, JLabel label2, JLabel label3) {
        goalAC = 0;
        goalRM = 0;
        label.setText("Result: " + goalAC + " x " + goalRM);
        label2.setText("Last Scorer: N/A");
        label3.setText("Winner: N/A");
    }
}

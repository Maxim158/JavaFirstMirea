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
        frame.setVisible(true);
        buttonAC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goalAC++;
                labelResult.setText("Result: " + goalAC + " x " + goalRM);
                labelLast.setText("Last Scorer: AC Milan");
                if (goalAC > goalRM) {
                    labelWinner.setText("Winner: AC Milan");
                } else {
                    if (goalRM > goalAC) {
                        labelWinner.setText("Winner: Real Madrid");
                    } else {
                        labelWinner.setText("Winner: Draw");
                    }
                }
            }
        });

        buttonRM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    goalRM++;
                    labelResult.setText("Result: " + goalAC + " x " + goalRM);
                    labelLast.setText("Last Scorer: Real Madrid");
                    if (goalAC > goalRM) {
                        labelWinner.setText("Winner: AC Milan");
                    }
                    else {
                        if(goalRM > goalAC) {
                            labelWinner.setText("Winner: Real Madrid");
                        }
                        else {
                            labelWinner.setText("Winner: Draw");
                        }
                    }
            }
        });

        buttonRST.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goalAC = 0;
                goalRM = 0;
                labelResult.setText("Result: " + goalAC + " x " + goalRM);
                labelLast.setText("Last Scorer: N/A");
                labelWinner.setText("Winner: N/A");
            }
        });
    }
}

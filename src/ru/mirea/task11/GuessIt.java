package ru.mirea.task11;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessIt {
    int attempt = 3;
    int countOfAttempt = 3;
    int maxNumber = 20;
    int guessingNumber = RandomNumber();
    public GuessIt() {
        JFrame frame = new JFrame("GuessIt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setSize(600, 350);
        frame.setResizable(false);
        JLabel labelTry = new JLabel("Attempts left: " + attempt);
        labelTry.setBounds(265,30,100,20);
        JLabel labelGuess = new JLabel("");
        labelGuess.setBounds(222,130,300,20);
        JButton buttonGuess = new JButton("Guess");
        buttonGuess.setBounds(250,230,100,30);
        JButton buttonRST = new JButton("New Game");
        buttonRST.setBounds(30,30,100,30);
        JTextField input = new JTextField(10);
        input.setBounds(200,200,200,20);
        JTextField setAttempts = new JTextField(10);
        setAttempts.setBounds(30,90,100,20);
        JTextField setMax = new JTextField(10);
        setMax.setBounds(30,130,100,20);
        JLabel textSetAttempts = new JLabel("Set Attempts");
        textSetAttempts.setBounds(30,70,100,20);
        JLabel textSetMax = new JLabel("Set Max Number");
        textSetMax.setBounds(30,110,100,20);
        JLabel current = new JLabel("Count of attempts - " + countOfAttempt + " Max number - " + maxNumber);
        current.setBounds(200,10,400,20);
        frame.setLayout(null);
        frame.add(current);
        frame.add(labelTry);
        frame.add(labelGuess);
        frame.add(buttonGuess);
        frame.add(buttonRST);
        frame.add(input);
        frame.add(setAttempts);
        frame.add(setMax);
        frame.add(textSetAttempts);
        frame.add(textSetMax);
        frame.setVisible(true);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);


        buttonGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int x1 = Integer.parseInt(input.getText().trim());

                    if (x1 == guessingNumber) {
                        JOptionPane.showMessageDialog(null, "Congratulations! You Win!", "Win", JOptionPane.INFORMATION_MESSAGE);
                        attempt = countOfAttempt;
                        guessingNumber = RandomNumber();
                        labelGuess.setText("");
                        labelTry.setText("Attempts left: " + attempt);
                    } else if (x1 > guessingNumber) {
                        attempt--;
                        labelTry.setText("Attempts left: " + attempt);
                        labelGuess.setText("Your number " + x1 + " is greater");
                    } else {
                        attempt--;
                        labelTry.setText("Attempts left: " + attempt);
                        labelGuess.setText("Your number " + x1 + " is lesser");
                    }
                    if (attempt == 0) {
                        JOptionPane.showMessageDialog(null, "You lose! Guessing number was: " + guessingNumber + "\n Try again.", "Lose", JOptionPane.INFORMATION_MESSAGE);
                        attempt = countOfAttempt;
                        labelGuess.setText("");
                        labelTry.setText("Attempts left: " + attempt);
                    }
                }
                catch(Exception a) {
                    JOptionPane.showMessageDialog(null, "Error in Numbers !", "alert", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        buttonRST.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int x1 = Integer.parseInt(setAttempts.getText().trim());
                    int x2 = Integer.parseInt(setMax.getText().trim());
                    countOfAttempt = x1;
                    maxNumber = x2;
                    attempt = countOfAttempt;
                    guessingNumber = RandomNumber();
                    labelTry.setText("Attempts left: " + attempt);
                    current.setText("Count of attempts - " + countOfAttempt + " Max number - " + maxNumber);
                }
                catch(Exception a) {
                    JOptionPane.showMessageDialog(null, "Error in Numbers !", "alert", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public int RandomNumber() {
        return (int) (Math.random() *maxNumber);
    }

}
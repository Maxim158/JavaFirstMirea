package ru.mirea.task16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Date;

public class SnakeGame extends JPanel implements  ActionListener {
    private final int SIZEX = 900;
    private final int SIZEY = 750;
    private final int DOT_SIZE = 25;
    private final int ALL_DOTS = 1080;
    private int GAME_SPEED = 100;
    private int score = 0;
    private Image apple;
    private Image snake_body;
    private Image snake_head_up;
    private Image snake_head_down;
    private Image snake_head_right;
    private Image snake_head_left;
    private int appleX;
    private int appleY;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots;
    private Timer timer;
    private char direction = 'R';
    private boolean inGame = true;
    private boolean ready = true;

    public SnakeGame(MainWindow game) {
        JFrame frame = new JFrame("NickName here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        JTextField Input = new JTextField(10);
        Input.setBounds(125, 150, 150, 30);
        Input.setText("");
        frame.add(Input);
        JLabel Name = new JLabel("Input your nickname:");
        Name.setBounds(125, 100, 150, 30);
        frame.add(Name);
        JButton ok = new JButton("OK");
        ok.setBounds(125, 200, 150, 30);
        frame.add(ok);
        frame.setVisible(true);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent exd) {
                setBackground(Color.BLACK);
                loadImage();
                initGame();
                addKeyListener(new FieldKeyListener());
                setFocusable(true);
                frame.dispose();
                game.setVisible(true);
            }
        });
    }

    public void initGame() {
        dots =  3;
        x[0] = 75;
        y[0] = 100;
        for (int i = 1; i  < dots; i++) {
            x[i] = 75 - i*DOT_SIZE;
            y[i] = 100;
        }
        timer = new Timer(GAME_SPEED, this);
        timer.start();
        createApple();
    }

    public void createApple() {
        appleX = new Random().nextInt(36) *DOT_SIZE;
        appleY = new Random().nextInt(30) *DOT_SIZE;
        for (int i = 0; i < dots; i++) {
            if (appleX == x[i] && appleY == y[i]) createApple();
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            dots++;
            score += 100;
            createApple();
        }
    }

    public void checkCollisions() {
        if ( dots > 3) {
            for (int i = dots; i > 0; i--) {
                if (x[0] == x[i] && y[0] == y[i]) {
                    inGame = false;
                }
            }
        }
    }

    public void move(){
        for (int i = dots; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        if (direction == 'R') {
            x[0] += DOT_SIZE;
            if (x[0] > 875) x[0] = 0;
        } else if (direction == 'L') {
            x[0] -= DOT_SIZE;
            if (x[0] < 0) x[0] = 875;
        } else if (direction == 'U') {
            y[0] -= DOT_SIZE;
            if (y[0] < 0) y[0] = 725;
        } else if (direction == 'D') {
            y[0] += DOT_SIZE;
            if (y[0] > 700) y[0] = 0;
        }
        ready = true;
    }

    public void loadImage() {
        ImageIcon image_apple = new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Apple.png");
        apple = image_apple.getImage();
        ImageIcon image_snake_body = new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Snake_body.png");
        snake_body = image_snake_body.getImage();
        ImageIcon image_snake_head_up = new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Snake_head_up.png");
        snake_head_up = image_snake_head_up.getImage();
        ImageIcon image_snake_head_down = new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Snake_head_down.png");
        snake_head_down = image_snake_head_down.getImage();
        ImageIcon image_snake_head_left = new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Snake_head_left.png");
        snake_head_left = image_snake_head_left.getImage();
        ImageIcon image_snake_head_right = new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Snake_head_right.png");
        snake_head_right = image_snake_head_right.getImage();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.drawImage(apple, appleX, appleY,this);
            if (direction == 'R') {
                g.drawImage(snake_head_right, x[0], y[0], this);
            } else if (direction == 'L') {
                g.drawImage(snake_head_left, x[0], y[0], this);
            } else if (direction == 'U') {
                g.drawImage(snake_head_up, x[0], y[0], this);
            } else if (direction == 'D') {
                g.drawImage(snake_head_down, x[0], y[0], this);
            }
            for (int i = 1; i < dots; i++) {
                g.drawImage(snake_body, x[i], y[i], this);
            }
        }
        else {
            String end = "Game Over";
            g.setColor(Color.WHITE);
            g.drawString(end,SIZEX/2 - 50,SIZEY/2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            move();
            score--;
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(ready) {
                if (key == KeyEvent.VK_LEFT && direction != 'R') {
                    direction = 'L';
                }
                if (key == KeyEvent.VK_RIGHT && direction != 'L') {
                    direction = 'R';
                }
                if (key == KeyEvent.VK_UP && direction != 'D') {
                    direction = 'U';
                }
                if (key == KeyEvent.VK_DOWN && direction != 'U') {
                    direction = 'D';
                }
                ready = false;
            }
        }
    }

}

package ru.mirea.task16;

import sun.dc.path.PathException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Date;

enum direct {
    up, down, left, right;
}
enum back_color {
    black, white, cyan , custom1, custom2;
}
enum snake_color {
    green, blue, red, custom1, custom2;
}
enum apple_color {
    classic, gold, worm, pear;
}

public class SnakeGame extends JPanel implements  ActionListener {
    private MainWindow game;
    private back_color background = back_color.black;
    private snake_color skin = snake_color.green;
    private apple_color appleskin = apple_color.classic;
    private final int SIZEX = 900;
    private final int SIZEY = 750;
    private final int DOT_SIZE = 25;
    private final int ALL_DOTS = 945;
    private int GAME_SPEED = 100;
    private boolean border = false;
    private int score = 0;
    private String name = "No Name";
    private int apple_eaten = 0;
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
    private direct direction = direct.right;
    private boolean inGame = true;
    private boolean ready = true;

    public SnakeGame(MainWindow gamewindow) {
       this.game = gamewindow;
        Menu(game);
    }

    public void initGame() {
        inGame = true;
        ready = true;
        score = 0;
        apple_eaten = 0;
        direction = direct.right;
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
        appleX = new Random().nextInt(35) *DOT_SIZE;
        appleY = new Random().nextInt(27) *DOT_SIZE + 50;
        for (int i = 0; i < dots; i++) {
            if (appleX == x[i] && appleY == y[i]) createApple();
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            dots++;
            apple_eaten ++;
            score += 100;
            if(dots != ALL_DOTS) {
                createApple();
            } else {
                timer.stop();
                inGame = false;
                scoreBuild();
            }
        }
    }

    public void checkCollisions() {
        if ( dots > 3) {
            for (int i = dots; i > 0; i--) {
                if (x[0] == x[i] && y[0] == y[i]) {
                    timer.stop();
                    inGame = false;
                    scoreBuild();
                }
            }
        }
    }

    public void move(){
        for (int i = dots; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        if (direction == direct.right) {
            x[0] += DOT_SIZE;
        } else if (direction == direct.left) {
            x[0] -= DOT_SIZE;
        } else if (direction == direct.up) {
            y[0] -= DOT_SIZE;
        } else if (direction == direct.down) {
            y[0] += DOT_SIZE;
        }
        if(border) {
            if (x[0] > 875) inGame = false;
            if (x[0] < 0) inGame = false;
            if (y[0] < 50) inGame = false;
            if (y[0] > 700) inGame = false;
        } else {
            if (x[0] > 875) x[0] = 0;
            if (x[0] < 0) x[0] = 875;
            if (y[0] < 50) y[0] = 700;
            if (y[0] > 700) y[0] = 50;
        }
        ready = true;
    }

    public void loadImage() {
        ImageIcon image_apple = new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Apple\\Worm\\Apple.png");
        apple = image_apple.getImage();


        ImageIcon image_snake_body = new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Snake\\Custom2\\Snake_body.png");
        snake_body = image_snake_body.getImage();
        ImageIcon image_snake_head_up = new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Snake\\Custom2\\Snake_head_up.png");
        snake_head_up = image_snake_head_up.getImage();
        ImageIcon image_snake_head_down = new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Snake\\Custom2\\Snake_head_down.png");
        snake_head_down = image_snake_head_down.getImage();
        ImageIcon image_snake_head_left = new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Snake\\Custom2\\Snake_head_left.png");
        snake_head_left = image_snake_head_left.getImage();
        ImageIcon image_snake_head_right = new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Snake\\Custom2\\Snake_head_right.png");
        snake_head_right = image_snake_head_right.getImage();

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.setColor(Color.lightGray);
            g.fillRect(0,0,910,50);
            g.setColor(Color.BLACK);
            g.drawString("Score: " + String.valueOf(score), 20,20);
            g.drawString("Apple eaten: " + String.valueOf(apple_eaten), 100,20);
            g.drawImage(apple, appleX, appleY,this);
            if (direction == direct.right) {
                g.drawImage(snake_head_right, x[0], y[0], this);
            } else if (direction == direct.left) {
                g.drawImage(snake_head_left, x[0], y[0], this);
            } else if (direction == direct.up) {
                g.drawImage(snake_head_up, x[0], y[0], this);
            } else if (direction == direct.down) {
                g.drawImage(snake_head_down, x[0], y[0], this);
            }
            for (int i = 1; i < dots; i++) {
                g.drawImage(snake_body, x[i], y[i], this);
            }
        }
        else if (dots != ALL_DOTS ){
            g.setColor(Color.WHITE);
            g.drawString("Game Over! Press any key to continue...",SIZEX/2 - 100,SIZEY/2);

        } else {
            g.setColor(Color.WHITE);
            g.drawString("You Win",SIZEX/2 - 50,SIZEY/2);
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
            if (ready) {
                if (key == KeyEvent.VK_LEFT && direction != direct.right) {
                    direction = direct.left;
                }
                if (key == KeyEvent.VK_RIGHT && direction != direct.left) {
                    direction = direct.right;
                }
                if (key == KeyEvent.VK_UP && direction != direct.down) {
                    direction = direct.up;
                }
                if (key == KeyEvent.VK_DOWN && direction != direct.up) {
                    direction = direct.down;
                }
                ready = false;
            } else if (!inGame) {
                game.dispose();
                Menu(game);
            }
        }
    }


    public void scoreBuild() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Scoreboard.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write("Player: " + name + " Score: " + score + " Apple eaten: " + apple_eaten + " " + new Date() + "\n");
            bufferWriter.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void Menu(MainWindow game) {
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setSize(500, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        JLabel gamePic = new JLabel(new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Snake_head_up.png"));
        gamePic.setBounds(220, 5, 150, 30);
        JLabel gameName = new JLabel("SNAKE");
        gameName.setFont(new Font("Serif", Font.PLAIN, 28));
        gameName.setBounds(175, 5, 150, 30);
        frame.add(gameName);
        frame.add(gamePic);
        JTextField Input = new JTextField(10);
        Input.setBounds(10, 70, 150, 30);
        Input.setText("");
        frame.add(Input);
        JLabel Name = new JLabel("Input your nickname:");
        Name.setBounds(10, 45, 150, 30);
        frame.add(Name);
        JLabel speed = new JLabel("Game speed(ms):");
        speed.setBounds(10, 110, 150, 30);
        frame.add(speed);
        JTextField speed_in = new JTextField(10);
        speed_in.setBounds(10, 135, 150, 30);
        speed_in.setText("100");
        frame.add(speed_in);
        JCheckBox bord = new JCheckBox("On/Off borders");
        bord.setBounds(10,180, 150,30);
        frame.add(bord);
        JButton play = new JButton("Start Game");
        play.setBounds(175, 120, 150, 30);
        JButton skin = new JButton("Change snake skin");
        skin.setBounds(175, 160, 150, 30);
        JButton ap_skin_but = new JButton("Change apple skin");
        ap_skin_but.setBounds(175, 200, 150, 30);
        JButton background = new JButton("Change background");
        background.setBounds(175, 240, 150, 30);
        frame.add(skin);
        frame.add(ap_skin_but);
        frame.add(background);
        frame.add(play);
        frame.setVisible(true);
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent exd)  {
                try {
                    name = Input.getText();
                    GAME_SPEED = Integer.parseInt(speed_in.getText());
                    setBackground(Color.BLACK);
                    loadImage();
                    initGame();
                    addKeyListener(new FieldKeyListener());
                    setFocusable(true);
                    frame.dispose();
                    game.setVisible(true);
                }
                catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Incorrect game speed!", "alert", JOptionPane.ERROR_MESSAGE);
                    speed_in.setText("100");
                }
            }
        });
        skin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skinChanger();
            }
        });
        ap_skin_but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appleChanger();
            }
        });
        background.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backgroundChanger();
            }
        });
        bord.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1) {
                    border = true;
                } else {
                    border = false;
                }
            }
        });
    }

    public void skinChanger(){}

    public void appleChanger(){}

    public void backgroundChanger(){}
}
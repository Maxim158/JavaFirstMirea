package ru.mirea.task16;

import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



enum direct {
    up, down, left, right;
}
enum back_color {
    black, white, cyan;
}
enum snake_color {
    green, blue, red, custom1, custom2;
}
enum apple_color {
    classic, gold, worm, pear, banana;
}
public class SnakeGame extends JPanel implements  ActionListener {

    static class NameException extends Exception {
        public NameException(String name) {
            super(name);
        }
    }
    private String path = "C:\\Users\\IVC1-5\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\";
    private MainWindow game;
    private JFrame menu;
    private back_color background = back_color.black;
    private snake_color skin = snake_color.green;
    private apple_color appleskin = apple_color.classic;
    private Color back_col = Color.BLACK;
    java.util.List<String> scoreboard = new ArrayList<>();
    String regex = "^[a-zA-Z]*$";
    Pattern pattern = Pattern.compile(regex);
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
                inGame = false;
            }
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

        switch (direction) {
        case right:
            x[0] += DOT_SIZE;
            break;
        case left:
            x[0] -= DOT_SIZE;
            break;
        case up:
            y[0] -= DOT_SIZE;
            break;
        case down:
            y[0] += DOT_SIZE;
            break;
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

    public void loadImageSkin() {
        ImageIcon image_snake_body;
        ImageIcon image_snake_head_up;
        ImageIcon image_snake_head_down;
        ImageIcon image_snake_head_left;
        ImageIcon image_snake_head_right;
        switch (skin) {
            case green:
                image_snake_body = new ImageIcon(path + "Snake\\Green\\Snake_body.png");
                snake_body = image_snake_body.getImage();
                image_snake_head_up = new ImageIcon(path + "Snake\\Green\\Snake_head_up.png");
                snake_head_up = image_snake_head_up.getImage();
                image_snake_head_down = new ImageIcon(path + "Snake\\Green\\Snake_head_down.png");
                snake_head_down = image_snake_head_down.getImage();
                image_snake_head_left = new ImageIcon(path + "Snake\\Green\\Snake_head_left.png");
                snake_head_left = image_snake_head_left.getImage();
                image_snake_head_right = new ImageIcon(path + "Snake\\Green\\Snake_head_right.png");
                snake_head_right = image_snake_head_right.getImage();
                break;
            case red:
                image_snake_body = new ImageIcon(path + "Snake\\Red\\Snake_body.png");
                snake_body = image_snake_body.getImage();
                image_snake_head_up = new ImageIcon(path + "Snake\\Red\\Snake_head_up.png");
                snake_head_up = image_snake_head_up.getImage();
                image_snake_head_down = new ImageIcon(path + "Snake\\Red\\Snake_head_down.png");
                snake_head_down = image_snake_head_down.getImage();
                image_snake_head_left = new ImageIcon(path + "Snake\\Red\\Snake_head_left.png");
                snake_head_left = image_snake_head_left.getImage();
                image_snake_head_right = new ImageIcon(path + "Snake\\Red\\Snake_head_right.png");
                snake_head_right = image_snake_head_right.getImage();
                break;
            case blue:
                image_snake_body = new ImageIcon(path + "Snake\\Blue\\Snake_body.png");
                snake_body = image_snake_body.getImage();
                image_snake_head_up = new ImageIcon(path + "Snake\\Blue\\Snake_head_up.png");
                snake_head_up = image_snake_head_up.getImage();
                image_snake_head_down = new ImageIcon(path + "Snake\\Blue\\Snake_head_down.png");
                snake_head_down = image_snake_head_down.getImage();
                image_snake_head_left = new ImageIcon(path + "Snake\\Blue\\Snake_head_left.png");
                snake_head_left = image_snake_head_left.getImage();
                image_snake_head_right = new ImageIcon(path + "Snake\\Blue\\Snake_head_right.png");
                snake_head_right = image_snake_head_right.getImage();
                break;
            case custom1:
                image_snake_body = new ImageIcon(path + "Snake\\Custom1\\Snake_body.png");
                snake_body = image_snake_body.getImage();
                image_snake_head_up = new ImageIcon(path + "Snake\\Custom1\\Snake_head_up.png");
                snake_head_up = image_snake_head_up.getImage();
                image_snake_head_down = new ImageIcon(path + "Snake\\Custom1\\Snake_head_down.png");
                snake_head_down = image_snake_head_down.getImage();
                image_snake_head_left = new ImageIcon(path + "Snake\\Custom1\\Snake_head_left.png");
                snake_head_left = image_snake_head_left.getImage();
                image_snake_head_right = new ImageIcon(path + "Snake\\Custom1\\Snake_head_right.png");
                snake_head_right = image_snake_head_right.getImage();
                break;
            case custom2:
                image_snake_body = new ImageIcon(path + "Snake\\Custom2\\Snake_body.png");
                snake_body = image_snake_body.getImage();
                image_snake_head_up = new ImageIcon(path + "Snake\\Custom2\\Snake_head_up.png");
                snake_head_up = image_snake_head_up.getImage();
                image_snake_head_down = new ImageIcon(path + "Snake\\Custom2\\Snake_head_down.png");
                snake_head_down = image_snake_head_down.getImage();
                image_snake_head_left = new ImageIcon(path + "Snake\\Custom2\\Snake_head_left.png");
                snake_head_left = image_snake_head_left.getImage();
                image_snake_head_right = new ImageIcon(path + "Snake\\Custom2\\Snake_head_right.png");
                snake_head_right = image_snake_head_right.getImage();
                break;
        }
    }

    public void loadImageApple() {
        ImageIcon image_apple;
        switch (appleskin) {
            case classic:
                image_apple = new ImageIcon(path + "Apple\\Classic\\Apple.png");
                apple = image_apple.getImage();
                break;
            case worm:
                image_apple = new ImageIcon(path + "Apple\\Worm\\Apple.png");
                apple = image_apple.getImage();
                break;
            case pear:
                image_apple = new ImageIcon(path + "Apple\\Pear\\Apple.png");
                apple = image_apple.getImage();
                break;
            case gold:
                image_apple = new ImageIcon(path + "Apple\\Gold\\Apple.png");
                apple = image_apple.getImage();
                break;
            case banana:
                image_apple = new ImageIcon(path + "Apple\\Banana\\Apple.png");
                apple = image_apple.getImage();
                break;
        }

    }

    public void loadImageBack() {
        switch (background) {
            case black:
                back_col = Color.BLACK;
                break;
            case white:
                back_col = Color.WHITE;
                break;
            case cyan:
                back_col = Color.CYAN;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            if (border) {
                g.setColor(Color.RED);
                g.drawRect(1,52,908,673);
                g.drawRect(0,51,910,675);
            }
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
            border = false;
            timer.stop();
            scoreBuild();
        } else {
            g.setColor(Color.WHITE);
            g.drawString("You Win",SIZEX/2 - 50,SIZEY/2);
            border = false;
            timer.stop();
            scoreBuild();
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
                    game.setVisible(false);
                    Menu(game);
            }
        }
    }


    public void scoreBuild() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\user\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\Scoreboard.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write("Player: " + name + " Score: " + score + " Apple eaten: " + apple_eaten + " " + new Date() + " " + game.hashCode() + "\n");
            scoreboard.add("Player: " + name + " Score: " + score + " Apple eaten: " + apple_eaten + " " + new Date());
            bufferWriter.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void Menu(MainWindow game) {
        menu = new JFrame("Snake");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.getContentPane().setBackground(Color.white);
        menu.setSize(500, 400);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);
        menu.setLayout(null);
        JLabel gamePic = new JLabel(new ImageIcon(path + "Snake\\Green\\Snake_head_up.png"));
        gamePic.setBounds(280, 10, 25, 25);
        JLabel gameName = new JLabel("SNAKE");
        gameName.setFont(new Font("Serif", Font.PLAIN, 28));
        gameName.setBounds(175, 5, 150, 30);
        menu.add(gameName);
        menu.add(gamePic);
        JTextField Input = new JTextField(10);
        Input.setBounds(10, 70, 150, 30);
        Input.setText("");
        menu.add(Input);
        JLabel Name = new JLabel("Input your nickname:");
        Name.setBounds(10, 45, 150, 30);
        menu.add(Name);
        JLabel speed = new JLabel("Game speed(ms):");
        speed.setBounds(10, 110, 150, 30);
        menu.add(speed);
        JTextField speed_in = new JTextField(10);
        speed_in.setBounds(10, 135, 150, 30);
        speed_in.setText("100");
        menu.add(speed_in);
        JCheckBox bord = new JCheckBox("On/Off borders");
        bord.setBounds(10,180, 150,30);
        menu.add(bord);
        JButton play = new JButton("Start Game");
        play.setBounds(175, 120, 150, 30);
        JButton skin = new JButton("Change snake skin");
        skin.setBounds(175, 160, 150, 30);
        JButton ap_skin_but = new JButton("Change apple skin");
        ap_skin_but.setBounds(175, 200, 150, 30);
        JButton background = new JButton("Change background");
        background.setBounds(175, 240, 150, 30);
        menu.add(skin);
        menu.add(ap_skin_but);
        menu.add(background);
        menu.add(play);
        menu.setVisible(true);
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent exd)  {

                try {
                    if (Input.getText().length() != 0) {
                        name = Input.getText();
                        Matcher matcher = pattern.matcher(name);
                        if (matcher.matches() == false) throw new NameException(name);
                    }
                    GAME_SPEED = Integer.parseInt(speed_in.getText());
                    setBackground(back_col);
                    loadImageSkin();
                    loadImageApple();
                    loadImageBack();
                    initGame();
                    addKeyListener(new FieldKeyListener());
                    setFocusable(true);
                    menu.setVisible(false);
                    game.setVisible(true);
                }
                catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(null, "Incorrect Game Speed!", "alert", JOptionPane.ERROR_MESSAGE);
                    speed_in.setText("100");

                }
                catch (NameException n) {
                    JOptionPane.showMessageDialog(null, "Incorrect player name!", "alert", JOptionPane.ERROR_MESSAGE);
                    Input.setText("");
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

    public void skinChanger(){
        menu.setVisible(false);
        JFrame snakeFrame = new JFrame("Skin Changer");
        snakeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        snakeFrame.getContentPane().setBackground(Color.white);
        snakeFrame.setSize(500, 400);
        snakeFrame.setResizable(false);
        snakeFrame.setLocationRelativeTo(null);
        snakeFrame.setLayout(null);
        JButton snake1 = new JButton("Select");
        JButton snake2 = new JButton("Select");
        JButton snake3 = new JButton("Select");
        JButton snake4 = new JButton("Select");
        JButton snake5 = new JButton("Select");
        JButton ok = new JButton("Confirm");
        snake1.setBounds(20, 80, 100, 30);
        snake2.setBounds(200, 80, 100, 30);
        snake3.setBounds(380, 80, 100, 30);
        snake4.setBounds(20, 200, 100, 30);
        snake5.setBounds(200, 200, 100, 30);
        ok.setBounds(175,300,150,30);
        JLabel greensnake1 = new JLabel(new ImageIcon(path + "Snake\\Green\\Snake_head_up.png"));
        JLabel greensnake2 = new JLabel(new ImageIcon(path + "Snake\\Green\\Snake_body.png"));
        JLabel greensnake3 = new JLabel(new ImageIcon(path + "Snake\\Green\\Snake_body.png"));
        JLabel bluesnake1 = new JLabel(new ImageIcon(path + "Snake\\Blue\\Snake_head_up.png"));
        JLabel bluesnake2 = new JLabel(new ImageIcon(path + "Snake\\Blue\\Snake_body.png"));
        JLabel bluesnake3 = new JLabel(new ImageIcon(path + "Snake\\Blue\\Snake_body.png"));
        JLabel redsnake1 = new JLabel(new ImageIcon(path + "Snake\\Red\\Snake_head_up.png"));
        JLabel redsnake2 = new JLabel(new ImageIcon(path + "Snake\\Red\\Snake_body.png"));
        JLabel redsnake3 = new JLabel(new ImageIcon(path + "Snake\\Red\\Snake_body.png"));
        JLabel customsnake1 = new JLabel(new ImageIcon(path + "Snake\\Custom1\\Snake_head_up.png"));
        JLabel customsnake2 = new JLabel(new ImageIcon(path + "Snake\\Custom1\\Snake_body.png"));
        JLabel customsnake3 = new JLabel(new ImageIcon(path + "Snake\\Custom1\\Snake_body.png"));
        JLabel custom2snake1 = new JLabel(new ImageIcon(path + "Snake\\Custom2\\Snake_head_up.png"));
        JLabel custom2snake2 = new JLabel(new ImageIcon(path + "Snake\\Custom2\\Snake_body.png"));
        JLabel custom2snake3 = new JLabel(new ImageIcon(path + "Snake\\Custom2\\Snake_body.png"));
        greensnake1.setBounds(30,12,25,25);
        greensnake2.setBounds(40,35,25,25);
        greensnake3.setBounds(60,50,25,25);
        bluesnake1.setBounds(220,12,25,25);
        bluesnake2.setBounds(230,35,25,25);
        bluesnake3.setBounds(250,50,25,25);
        redsnake1.setBounds(390,12,25,25);
        redsnake2.setBounds(400,35,25,25);
        redsnake3.setBounds(420,50,25,25);
        customsnake1.setBounds(30,132,25,25);
        customsnake2.setBounds(40,155,25,25);
        customsnake3.setBounds(60,170,25,25);
        custom2snake1.setBounds(220,132,25,25);
        custom2snake2.setBounds(230,155,25,25);
        custom2snake3.setBounds(250,170,25,25);
        snakeFrame.add(snake1);
        snakeFrame.add(snake2);
        snakeFrame.add(snake3);
        snakeFrame.add(snake4);
        snakeFrame.add(snake5);
        snakeFrame.add(ok);
        snakeFrame.add(greensnake1);
        snakeFrame.add(greensnake2);
        snakeFrame.add(greensnake3);
        snakeFrame.add(bluesnake1);
        snakeFrame.add(bluesnake2);
        snakeFrame.add(bluesnake3);
        snakeFrame.add(redsnake1);
        snakeFrame.add(redsnake2);
        snakeFrame.add(redsnake3);
        snakeFrame.add(customsnake1);
        snakeFrame.add(customsnake2);
        snakeFrame.add(customsnake3);
        snakeFrame.add(custom2snake1);
        snakeFrame.add(custom2snake2);
        snakeFrame.add(custom2snake3);
        switch (skin) {
            case green:
                snake1.setEnabled(false);
                break;
            case blue:
                snake2.setEnabled(false);
                break;
            case red:
                snake3.setEnabled(false);
                break;
            case custom1:
                snake4.setEnabled(false);
                break;
            case custom2:
                snake5.setEnabled(false);
                break;
        }
        snakeFrame.setVisible(true);

        snake1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skin = snake_color.green;
                snake1.setEnabled(false);
                snake2.setEnabled(true);
                snake3.setEnabled(true);
                snake4.setEnabled(true);
                snake5.setEnabled(true);
            }
        });

        snake2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skin = snake_color.blue;
                snake1.setEnabled(true);
                snake2.setEnabled(false);
                snake3.setEnabled(true);
                snake4.setEnabled(true);
                snake5.setEnabled(true);
            }
        });

        snake3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skin = snake_color.red;
                snake1.setEnabled(true);
                snake2.setEnabled(true);
                snake3.setEnabled(false);
                snake4.setEnabled(true);
                snake5.setEnabled(true);
            }
        });

        snake4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skin = snake_color.custom1;
                snake1.setEnabled(true);
                snake2.setEnabled(true);
                snake3.setEnabled(true);
                snake4.setEnabled(false);
                snake5.setEnabled(true);
            }
        });

        snake5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skin = snake_color.custom2;
                snake1.setEnabled(true);
                snake2.setEnabled(true);
                snake3.setEnabled(true);
                snake4.setEnabled(true);
                snake5.setEnabled(false);
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakeFrame.setVisible(false);
                menu.setVisible(true);
            }
        });

    }

    public void appleChanger(){
        menu.setVisible(false);
        JFrame appleFrame = new JFrame("Apple Changer");
        appleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appleFrame.getContentPane().setBackground(Color.white);
        appleFrame.setSize(500, 400);
        appleFrame.setResizable(false);
        appleFrame.setLocationRelativeTo(null);
        appleFrame.setLayout(null);
        JButton apple1 = new JButton("Select");
        JButton apple2 = new JButton("Select");
        JButton apple3 = new JButton("Select");
        JButton apple4 = new JButton("Select");
        JButton apple5 = new JButton("Select");
        JButton ok = new JButton("Confirm");
        apple1.setBounds(20, 80, 100, 30);
        apple2.setBounds(200, 80, 100, 30);
        apple3.setBounds(380, 80, 100, 30);
        apple4.setBounds(20, 200, 100, 30);
        apple5.setBounds(200, 200, 100, 30);
        ok.setBounds(175,300,150,30);
        JLabel app1 = new JLabel(new ImageIcon(path + "Apple\\Classic\\Apple.png"));
        JLabel app2 = new JLabel(new ImageIcon(path + "Apple\\Worm\\Apple.png"));
        JLabel app3 = new JLabel(new ImageIcon(path + "Apple\\Gold\\Apple.png"));
        JLabel app4 = new JLabel(new ImageIcon(path + "Apple\\Pear\\Apple.png"));
        JLabel app5 = new JLabel(new ImageIcon(path + "Apple\\Banana\\Apple.png"));
        app1.setBounds(60,50,25,25);
        app2.setBounds(240,50,25,25);
        app3.setBounds(420,50,25,25);
        app4.setBounds(60,170,25,25);
        app5.setBounds(240,170,25,25);
        appleFrame.add(apple1);
        appleFrame.add(apple2);
        appleFrame.add(apple3);
        appleFrame.add(apple4);
        appleFrame.add(apple5);
        appleFrame.add(app1);
        appleFrame.add(app2);
        appleFrame.add(app3);
        appleFrame.add(app4);
        appleFrame.add(app5);
        appleFrame.add(ok);
        switch (appleskin) {
            case classic:
                apple1.setEnabled(false);
                break;
            case worm:
                apple2.setEnabled(false);
                break;
            case gold:
                apple3.setEnabled(false);
                break;
            case pear:
                apple4.setEnabled(false);
                break;
            case banana:
                apple5.setEnabled(false);
                break;
        }
        appleFrame.setVisible(true);
        apple1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appleskin = apple_color.classic;
                apple1.setEnabled(false);
                apple2.setEnabled(true);
                apple3.setEnabled(true);
                apple4.setEnabled(true);
                apple5.setEnabled(true);
            }
        });

        apple2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appleskin = apple_color.worm;
                apple1.setEnabled(true);
                apple2.setEnabled(false);
                apple3.setEnabled(true);
                apple4.setEnabled(true);
                apple5.setEnabled(true);
            }
        });

        apple3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appleskin = apple_color.gold;
                apple1.setEnabled(true);
                apple2.setEnabled(true);
                apple3.setEnabled(false);
                apple4.setEnabled(true);
                apple5.setEnabled(true);
            }
        });

        apple4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appleskin = apple_color.pear;
                apple1.setEnabled(true);
                apple2.setEnabled(true);
                apple3.setEnabled(true);
                apple4.setEnabled(false);
                apple5.setEnabled(true);
            }
        });

        apple5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appleskin = apple_color.banana;
                apple1.setEnabled(true);
                apple2.setEnabled(true);
                apple3.setEnabled(true);
                apple4.setEnabled(true);
                apple5.setEnabled(false);
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appleFrame.setVisible(false);
                menu.setVisible(true);
            }
        });
    }

    public void backgroundChanger(){
        menu.setVisible(false);
        JFrame backFrame = new JFrame("Background Changer");
        backFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backFrame.getContentPane().setBackground(Color.white);
        backFrame.setSize(500, 400);
        backFrame.setResizable(false);
        backFrame.setLocationRelativeTo(null);
        backFrame.setLayout(null);
        JButton back1 = new JButton("Select");
        JButton back2 = new JButton("Select");
        JButton back3 = new JButton("Select");
        JButton ok = new JButton("Confirm");
        back1.setBounds(20, 80, 100, 30);
        back2.setBounds(200, 80, 100, 30);
        back3.setBounds(380, 80, 100, 30);
        ok.setBounds(175,300,150,30);
        JLabel blackb = new JLabel("Black");
        JLabel cyanb = new JLabel("Cyan");
        JLabel whiteb = new JLabel("White");
        blackb.setBounds(40,30,100,50);
        cyanb.setBounds(220,30,100,50);
        whiteb.setBounds(400,30,100,50);
        backFrame.add(back1);
        backFrame.add(back2);
        backFrame.add(back3);
        backFrame.add(blackb);
        backFrame.add(cyanb);
        backFrame.add(whiteb);
        backFrame.add(ok);

        switch (background) {
            case black:
                back1.setEnabled(false);
                break;
            case cyan:
                back2.setEnabled(false);
                break;
            case white:
                back3.setEnabled(false);
                break;
        }
        backFrame.setVisible(true);

        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                background = back_color.black;
                back_col = Color.BLACK;
                back1.setEnabled(false);
                back2.setEnabled(true);
                back3.setEnabled(true);
            }
        });
        back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                background = back_color.cyan;
                back_col = Color.CYAN;
                back1.setEnabled(true);
                back2.setEnabled(false);
                back3.setEnabled(true);
            }
        });
        back3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                background = back_color.white;
                back_col = Color.WHITE;
                back1.setEnabled(true);
                back2.setEnabled(true);
                back3.setEnabled(false);
            }
        });
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backFrame.setVisible(false);
                menu.setVisible(true);
            }
        });
    }
}
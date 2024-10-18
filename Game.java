import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener{
    private Snake snake;
    private Apple apple;
    private boolean gameOver;
    private int numberOfApplesEaten;
    
    private final int GRID_WIDTH = 600;
    private final int GRID_HEIGHT = 600;
    private final int TILE_SIZE = 20;


    //Constructors
    public Game() {
        snake  = new Snake (TILE_SIZE);
        apple = new Apple (TILE_SIZE);
        gameOver = false;
        numberOfApplesEaten = 0;


        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        
    }
    
    //Graphics for Snake, Apple, and Background
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        snake.draw(g);
        apple.draw(g);

        if (gameOver) {
            g.setColor(Color.RED);
            g.drawString("Game Over", GRID_WIDTH / 2 - 30, GRID_HEIGHT / 2);
            g.setColor(Color.GREEN);
            g.drawString(String.format("Your Score is %s", numberOfApplesEaten),GRID_WIDTH / 2 - 30, (GRID_HEIGHT / 2 + 20));
        }
    }

    //Updates game continously, also sets game rules such as collisions and snake growing
    public void updateGame(){
        if (!gameOver) {
            snake.move();
        }

        if (snake.checkSelfCollision()){
            gameOver = true;
        };

        if(snake.checkIfSnakeCollidedWithBoundry(GRID_WIDTH, GRID_HEIGHT)){
            gameOver = true;
            System.out.println("GAME OVER");
        }

        if (didSnakeEatApple(snake.getHeadX(), snake.getHeadY(), apple.getX(), apple.getY())){
            numberOfApplesEaten++;
            snake.grow();
            apple.newRandomApplePosition(GRID_WIDTH, GRID_HEIGHT);
        }
    }
    //Bool logic for if snake and apple meet
    public boolean didSnakeEatApple(int snakePositionX, int snakePositionY, int applePositionX, int applePositionY){
        return (snakePositionX == applePositionX && snakePositionY == applePositionY);
    }
    
    //Keyboard Controls for snake
    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                snake.setDirection(0,-1);
                break;
            case KeyEvent.VK_DOWN:
                snake.setDirection(0,1);
                break;
            case KeyEvent.VK_LEFT:
                snake.setDirection(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                snake.setDirection(1,0);
                break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

 }

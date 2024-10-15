//REFERENCE OTHER CLASS DESIGN METHODS TO FIGURE HOW TO DO THIS
//CHECK HOW TO DO RANDOM PLACEMENT OF APPLE
//NEED CLASS TO HANDLE SNAKE EATING APPLE AND GROWING
import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;


public class Apple{
    private int x;
    private int y;
    private int tileSize;
    private Random random;

    public Apple(int tileSize){
        this.tileSize = tileSize;
        random = new Random();
        newRandomApplePosition(600, 600);
    }

    public void newRandomApplePosition(int GRID_WIDTH, int GRID_HEIGHT){
        int maxTilesX = GRID_WIDTH / tileSize;
        int maxTilesY = GRID_HEIGHT / tileSize;

        x = random.nextInt(maxTilesX) * tileSize;
        y = random.nextInt(maxTilesY) * tileSize;
    }

    public void draw(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillOval(x,y,tileSize,tileSize);
    }

    public int getX(){return x;}
    public int getY(){return y;}
    
}
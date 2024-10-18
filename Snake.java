import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Snake{
    private int directionX;
    private int directionY;
    private int tileSize;
    private LinkedList<int[]> segments;

    //Constructor
    public Snake(int tileSize){
        this.tileSize = tileSize;
        this.directionX = 1;
        this.directionY = 0;
        segments = new LinkedList<>();
        segments.add(new int[] {100, 100});
    }
    //Setters for Snake Direction
    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }
    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

    public void setDirection(int dx, int dy){
        setDirectionX(dx);
        setDirectionY(dy);
    }

    //Snake Movement
    public void move(){
        int[] newHead = {segments.getFirst()[0] + directionX * tileSize, segments.getFirst()[1] + directionY * tileSize};
    segments.addFirst(newHead);
    segments.removeLast();
    }

    //Enables snake growth
    public void grow() {
        segments.addLast(segments.getLast());
    }

    //Bool for if snake collides with boundry
    public boolean checkIfSnakeCollidedWithBoundry(int gridWidth, int gridHeight){
        return segments.getFirst()[0] < 0 || segments.getFirst()[1] <0 || segments.getFirst()[0] >= gridWidth || segments.getFirst()[1] >= gridHeight;
    }

    //Bool for if snake collides with itself
    public boolean checkSelfCollision() {
        int[] head = segments.getFirst();

        for(int i = 1; i < segments.size(); i++)
        {
            int[] segment = segments.get(i);

            if (head[0] == segment[0] && head[1] == segment[1]) {
                return true;
            }
        }
        return false;
    }

    //Getter for head position of Snake
    public int getHeadX(){
        return segments.getFirst()[0];

    }

    public int getHeadY(){
        return segments.getFirst()[1];
    }

    //Graphics for addional segments
    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        for (int[] segment : segments) {
            g.fillRect(segment[0], segment[1], tileSize, tileSize);
        }
        
    }
    
}
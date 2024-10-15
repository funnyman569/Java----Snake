import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main()
    {
        JFrame frame = new JFrame("Snake Game");
        Game game = new Game();

        frame.add(game);
        frame.setSize(620, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                game.updateGame();
                game.repaint();
            }
        });
        timer.start(); 
    }
}

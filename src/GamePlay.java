import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.Time;

public class GamePlay  extends JPanel implements KeyListener,ActionListener {
    private boolean play = false;
    private int score = 0;
    private int totalbricks = 21;
    private Time Timer;
    private int delay = 8;
    private int playerX = 310;
    private int ballposX = 120;
    private int ballposY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;
    private MapGenerator map;

    public GamePlay(){
        map = new MapGenerator(3,7);
    }
    public void paint(Graphics g){
        //canvas
        g.setColor(Color.black);
        g.fillRect(1,1,692,592);

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(691,3,3,592);

        //display
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString(""+score,590,30);

        //player
        g.setColor(Color.yellow);
        g.fillRect(playerX,550,100,8);

        //ball
        g.setColor(Color.green);
        g.fillOval(ballposX,ballposY,20,20);


        if(ballposY > 570){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD,30));
            g.drawString("Press enter to restart",190,300);

            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Press Enter to Restart",190,340);
        }
        if(totalbricks == 0){
            play = false;
            ballYdir = 2;
            ballXdir = -1;
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Game Over",190,300);
        }
        g.dispose();
    }

}

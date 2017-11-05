import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Key;
import java.util.ArrayList;

public class GameBoard extends JPanel implements ActionListener {
    Timer timer;
    ArrayList <LightCycle> cycleArray;
    String myname;
    String userName;
    int x;
    int y;
    int maxX = 3;
    int maxY = 3;
    int minX = -3;
    int minY = -3;
    int velX;
    int velY;


    public GameBoard(ArrayList<LightCycle> cycleArray, String myname){
        setSize(500,500);
        setBackground(Color.white);
        this.cycleArray = cycleArray;
        this.myname = myname;
        for (LightCycle cycle:cycleArray){
            if (cycle.getUsername()==myname){
                setX(cycle.getX());
                setY(cycle.getY());
            }

        }
        setY(y);
        setX(x);
        timer = new Timer(20, this);
        timer.start();
        setOpaque(true);
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap =getActionMap();
        inputMap.put(KeyStroke.getKeyStroke("UP"),"UPACTION");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "DOWNACTION");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"),"LEFTACTION");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "RIGHTACTION");
        inputMap.put(KeyStroke.getKeyStroke("SPACE"), "SPACEACTION");
        actionMap.put("UPACTION",UPACTION);
        actionMap.put("DOWNACTION", DOWNACTION);
        actionMap.put("LEFTACTION", LEFTACTION);
        actionMap.put("RIGHTACTION", RIGHTACTION);
        actionMap.put("SPACEACTION", SPACEACTION);
    }
    Action UPACTION = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (getVelY() == minY) {
                velX = 0;
                velY -= 0;
            } else {
                velX = 0;
                velY -= 1;
            }
        }
    };

    Action DOWNACTION = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (getVelY() == maxY) {
                velX = 0;
                velY -= 0;
            } else {
                velX += 1;
                velY = 0;
            }
        }
    };

    Action LEFTACTION = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (getVelX() == minX) {
                velX -= 0;
                velY = 0;
            } else {
                velX -= 1;
                velY = 0;
            }
        }
    };

    Action RIGHTACTION = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (getVelX() == maxX) {
                velX -= 0;
                velY = 0;
            } else {
                velX += 1;
                velY = 0;
            }
        }
    };

    Action SPACEACTION = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    public void moveCycle(){
        x = x+ velX;
        y = y+ velY;
//        Collision detection goes here
    }



    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return maxY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveCycle();
        repaint();
        String message = ("USER POSITION" + myname + " " + x + " " + y );
        try {
            ClientSend.sendMessage(message);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public void paint (Graphics graphics){
        super.paint(graphics);
        for (LightCycle cycle:cycleArray){
            cycle.draw(graphics);
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Key;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CyclicBarrier;

public class GameBoard extends JPanel implements ActionListener {
    Timer timer;
    ArrayList <LightCycle> cycleArray;
    String myname;
    String userName;
    private int x;
    private int y;
    private int maxX = 3;
    private int maxY = 3;
    private int minX = -3;
    private int minY = -3;
    private int velX;
    private int velY;
    private boolean trail;
    ArrayList <Trail> trailArrray;
    int [][] cycleTrailArray;


    public GameBoard(ArrayList<LightCycle> cycleArray, String myname, ArrayList<Trail> trailArray, int[][] cycleTrailArray){
        setSize(500,500);
        setBackground(Color.white);
        this.cycleArray = cycleArray;
        this.myname = myname;
        this.cycleTrailArray = cycleTrailArray;
        this.trailArrray = trailArray;
        for (LightCycle cycle:cycleArray){
            if (Objects.equals(cycle.getUsername(), myname)){
                setX(cycle.getX());
                setY(cycle.getY());
            }

        }
        setY(y);
        setX(x);
        timer = new Timer(20, this);
        timer.start();
        trail = false;
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
                velX = 0;
                velY += 1;
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
            if (getTrail() == false){
                setTrail(true);
            }
            else {
                setTrail(false);
            }

        }
    };

    public void move(){
        x = x+ velX;
        y = y+ velY;

        if(cycleTrailArray[x][y]==1){
            timer.stop();
            JOptionPane.showMessageDialog(null,"You Died, Please Play Again so my life is meaningless");
        }
        if (y + velY <2 || y + velY >498){
            timer.stop();
            JOptionPane.showMessageDialog(null,"You Died, Please Play Again so my life is meaningless");
        }
        if (x + velX <2 || x + velX >498){
            timer.stop();
            JOptionPane.showMessageDialog(null,"You Died, Please Play Again so my life is meaningless");

        }
//        Collision detection goes here
    }

    public void setTrail(boolean trail){
        this.trail = trail;
    }

public boolean getTrail(){
        return trail;
}

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        String message = ("USER POSITION " + myname + " " + x + " " + y + " " + getTrail());
        try {
            ClientSend.sendMessage(message);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        for (LightCycle cycle:cycleArray){
            cycle.draw(graphics);
        }
        for(Trail trail:trailArrray){
            trail.draw(graphics);
        }
    }
}

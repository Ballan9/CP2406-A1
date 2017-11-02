import javax.swing.*;
import java.awt.event.*;

public class GamePanel extends JFrame implements ActionListener{

    Timer myTimer;
    TronCycle tp;
    StartScreen s;


    public static void main(String[] args) { GamePanel t = new GamePanel();
       int height = Integer.parseInt(JOptionPane.showInputDialog(null, " Please Enter the height"));
       int width = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter the Width"));
       new GamePanel(height, width);
    }
    public GamePanel(int height, int width) {

        JFrame GameGrid = new JFrame();
        GameGrid.setSize(height, width);
        GameGrid.setVisible(true);
        GameGrid.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GameGrid.setLocationRelativeTo(null);

        myTimer = new Timer(10, this);

        s = new StartScreen(this);
        add(s);
        tp = new TronCycle(this);
    }

    public void start() {myTimer.start(); }

    public void startGame () { add(tp)};

    @override
    public void actionPErformed(ActionEvent) {
        if (tp.collide()==false){
            tp.p1move(tp.p1direction());
            tp.p2move(tp.p2direction());
            tp.repaint();
        }
        if(tp.collide()==true){
            myTimer.stop();
        }
    }


    }






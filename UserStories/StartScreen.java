import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartScreen extends JPanel implements ActionListener{

    private GamePanel mainFrame;

    public StartScreen(GamePanel m){
        setSize ( 600, 600);

        FlowLayout flo = new FlowLayout();
        setLayout(flo);

        mainFrame = m;

        JButton start = new JButton ("start");
        JButton controls = new JButton ("Controls");
        start.addActionListener(this);
        controls.addActionListener(this);
        add(start);
        add(controls);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        setVisible(false);
        mainFrame.startGame();
    }
}

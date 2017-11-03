import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MulticastSocket;

public class GamePanel extends JFrame {
    GamePanel gamePanel;

    public GamePanel() {
        gamePanel = this;
        setTitle("Tron LightCycles");
        setSize(500, 500);

        // Create JButton and JPanel
        JButton stButton = new JButton("Start");
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        stButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog("Please Enter Your Name");
                MulticastClient client = new MulticastClient(gamePanel,panel);
                client.start();
                try {
                    ClientSend.sendMessage("USERNAME "+ username);
                    //gamePanel.validate();
                    //gamePanel.repaint();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Add button to JPanel
        panel.add(stButton);
        // And JPanel needs to be added to the JFrame itself!
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        GamePanel a = new GamePanel();
    }

}





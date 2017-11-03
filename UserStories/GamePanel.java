import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MulticastSocket;

public class GamePanel extends JFrame {

    public GamePanel() {

        setTitle("Tron LightCcles");
        setSize(500, 500);

        // Create JButton and JPanel
        JButton stButton = new JButton("Start");
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        stButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MulticastClient client = new MulticastClient();
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





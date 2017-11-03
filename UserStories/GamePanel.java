import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JFrame implements ActionListener {

    public GamePanel() {

        setTitle("Tron LightCcles");
        setSize(500, 500);

        // Create JButton and JPanel
        JButton button = new JButton("Start");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        @Override
        public void actionPerformed(ActionEvent e) {
            button.removeActionListener(this);
        }




        JPanel panel = new JPanel();

        // Add button to JPanel
        panel.add(button);
        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        GamePanel a = new GamePanel();
    }


}





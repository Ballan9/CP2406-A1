import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;

public class UserTest4 {

    public static void main(String[] args) {
       int height = Integer.parseInt(JOptionPane.showInputDialog(null, " Please Enter the height"));
       int width = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter the Width"));
       makeGameGrid(height, width);
    }
    public static void makeGameGrid(int height, int width){
        JFrame GameGrid = new JFrame();
        GameGrid.setSize(height, width);
        GameGrid.setVisible(true);
        GameGrid.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GameGrid.setLocationRelativeTo(null);


    }
}



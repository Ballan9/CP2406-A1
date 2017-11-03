import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastClient extends Thread {
    private GamePanel gamePanel;
    private JPanel panel;

    public MulticastClient(GamePanel gamePanel, JPanel panel){
        this.gamePanel = gamePanel;
        this.panel = panel;}
    public void run (){

        try{
        MulticastSocket socket = new MulticastSocket(4545);
        InetAddress address = InetAddress.getByName("228.5.5.5");
        socket.joinGroup(address);

        DatagramPacket packet;

        while (true) {
            byte[] buf = new byte[1024];
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            String received = new String(buf);
            if (received.startsWith("END")){
                break;
            }
            else if(received.startsWith("Starting game ")){
                gamePanel.remove(panel);
                GameBoard gameBoard = new GameBoard();
                gamePanel.add(gameBoard);
                gamePanel.validate();
                gamePanel.repaint();}
            System.out.println("Message "+ received);
        }

        socket.leaveGroup(address);
        socket.close();
    } catch(Exception e){
            e.printStackTrace();
        }}


}
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastClient extends Thread {
    private GamePanel gamePanel;
    private JPanel panel;
    String [] message;
    String userName;
    int x;
    int y;


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

            else if (received.startsWith("ADD USER")){
                message = received.split(" ");
                userName = message[2];
                x = Integer.parseInt(message[3]);
                y = Integer.parseInt(message[4]);


            }System.out.println("Message "+ received);
        }

        socket.leaveGroup(address);
        socket.close();
    } catch(Exception e){
            e.printStackTrace();
        }}


}
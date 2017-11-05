import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastClient extends Thread {
    private GamePanel gamePanel;
    private JPanel panel;
    String myname;
    String [] message;
    String userName;
    int x;
    int y;
    boolean trail;
    ArrayList <LightCycle> CycleArray;
    int [][] cycleTrailArray;
    ArrayList<Trail> trailArray;


    public MulticastClient(GamePanel gamePanel, JPanel panel, String myname){
        this.gamePanel = gamePanel;
        CycleArray = new ArrayList<>();
        trailArray = new ArrayList<>();
        this.myname = myname;
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
                GameBoard gameBoard = new GameBoard(CycleArray,myname,trailArray);
                gamePanel.add(gameBoard);
                gamePanel.validate();
                gamePanel.repaint();}

            else if (received.startsWith("ADD USER")){
                message = received.split(" ");
                userName = message[2].trim();
                x = Integer.parseInt(message[3].trim());
                y = Integer.parseInt(message[4].trim());
                LightCycle cycle = new LightCycle(userName, myname, x, y);
                CycleArray.add(cycle);


            }
            else if (received.startsWith("USER POSITION")){
//                System.out.println("*****************************");
            message = received.split(" ");
            userName = message[2].trim();
            x = Integer.parseInt(message[3].trim());
            y = Integer.parseInt(message[4].trim());
            trail = Boolean.parseBoolean(message[5].trim());
                for (LightCycle cycle:CycleArray){

                    if (Objects.equals(userName, cycle.getUsername())){
                        if(trail == true){
                            Trail trail = new Trail(myname,userName,x,y);
                            trailArray.add(trail);
                        }
                        cycle.setX(x);
                        cycle.setY(y);
                    }
                }
            }

            System.out.println("Message "+ received);
        }

        socket.leaveGroup(address);
        socket.close();
    } catch(Exception e){
            e.printStackTrace();
        }}


}
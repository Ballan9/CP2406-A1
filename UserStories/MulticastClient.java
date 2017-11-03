import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastClient extends Thread {


    public void run (){

        try{
        MulticastSocket socket = new MulticastSocket(4446);
        InetAddress address = InetAddress.getByName("230.0.0.1");
        socket.joinGroup(address);

        DatagramPacket packet;

        while (true) {
            byte[] buf = new byte[1024];
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            String received = new String(buf);
            System.out.println("Quote of the Moment: " + received);
            if (received.startsWith("END")){
                break;
            }
        }

        socket.leaveGroup(address);
        socket.close();
    } catch(Exception e){
            e.printStackTrace();
        }}

}
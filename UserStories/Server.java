import javax.swing.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        DatagramSocket socket = new DatagramSocket(9999);
        int userCount = 0;
        String username;
        String[] messageBreak;
        ArrayList<String> usernameList = new ArrayList<>();

    while (true){

        byte[] messageBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(messageBuffer, 1024);
        socket.receive(receivePacket);
        String message = new String(messageBuffer).trim();
        System.out.println(message);
        if (message.startsWith("END")){
            break;
        }
        else if (message.startsWith("USERNAME")){
            userCount ++;
            messageBreak = message.split(" ");
            username = messageBreak[1];
            usernameList.add(username);

            if (userCount==2){
                BroadcastMessage("Starting game ");

            }
            //BroadcastMessage("This is a Message");
        }


    }socket.close();
    }
    public static void BroadcastMessage(String message) throws Exception {
        InetAddress broadcastAddress = InetAddress.getByName("228.5.5.5");
        MulticastSocket group = new MulticastSocket(4545);
        DatagramPacket sendpacket = new DatagramPacket(message.getBytes(), message.length(), broadcastAddress, 4545);
        group.send(sendpacket);
        System.out.println("Server Sent " + message);
    }
}

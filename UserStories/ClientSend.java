import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientSend {

    public static void sendMessage(String message)throws Exception{
        DatagramSocket socket = new DatagramSocket(6987);
        InetAddress serverAddress = InetAddress.getByName("10.143.60.227");
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(),serverAddress,9999);
        socket.send(packet);
        socket.close();
    }
}

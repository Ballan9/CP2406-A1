import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientSend {

    public static void sendMessage(String message)throws Exception{
        DatagramSocket socket = new DatagramSocket(6983);
        InetAddress serverAddress = InetAddress.getByName("10.0.0.20");
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(),serverAddress,9999);
        socket.send(packet);
        socket.close();
    }
}

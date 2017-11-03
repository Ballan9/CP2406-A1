import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientSend {

    public static void sendMessage(String message)throws Exception{
        DatagramSocket socket = new DatagramSocket(6987);
        InetAddress address = InetAddress.getByName("10.999.99.999");
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(),address,99999);
        socket.send(packet);
        socket.close();
    }
}

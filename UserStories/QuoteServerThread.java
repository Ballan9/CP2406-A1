import java.io.*;
import java.net.*;
import java.util.*;



public class QuoteServerThread extends Thread {
    // Notice that the server uses a DatagramSocket to broadcast packet received
    // by the client over a MulticastSocket. Alternatively, it could have used
    // a MulticastSocket. The socket used by the server to send the
    // DatagramPacket is not important. What's important when broadcasting
    // packets is the addressing information contained in the DatagramPacket,
    // and the socket used by the client to listen for it.
    protected DatagramSocket socket = null;
    protected BufferedReader in = null;
    protected boolean moreQuotes = true;
    private static int TTL = 128;

    public QuoteServerThread() throws IOException {
        this("QuoteServerThread");
    }

    public QuoteServerThread(String name) throws IOException {
        super(name);
        socket = new DatagramSocket(4445);
        try {
            in = new BufferedReader(new FileReader("one-liners.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Could not open quote file. Serving time instead.");
        }
    }

    protected String getNextQuote() {
        String returnValue = null;
        try {
            if ((returnValue = in.readLine()) == null) {
                in.close();
                moreQuotes = false;
                returnValue = "No more quotes. Goodbye.";
            }
        } catch (IOException e) {
            returnValue = "IOException occurred in server.";
        }
        return returnValue;
    }
}
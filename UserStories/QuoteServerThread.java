import java.io.*;
import java.net.*;
import java.util.*;

// 由於在我們的範例中，MulticastServerThread 繼承了 QuoteServerThread
// 也 override 了其 run()，所以為了簡化，原來範例中的 run() 我們
// 就把他刪除了。

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

        // The port number doesn't actually matter in this example because
        // the client never send anything to the server.
        // 注意 DatagramSocket 不支援 setTimeToLive()
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
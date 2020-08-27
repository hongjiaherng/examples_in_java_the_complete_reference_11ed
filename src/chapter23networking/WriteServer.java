// Demonstrate datagram

package chapter23networking;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

class WriteServer {

    public static int serverPort = 998;
    public static int clientPort = 999;
    public static int buffer_size = 1024;
    public static DatagramSocket ds;
    public static byte[] buffer = new byte[buffer_size];

    public static void TheServer() throws IOException {
        InputStream input = new BufferedInputStream(System.in);
        int pos = 0;
        while (true) {
            int c = input.read();
            switch (c) {
                case '\r':
                    break;

                case '\n':
                    ds.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), clientPort));
                    pos = 0;
                    break;

                default:
                    if (c == '-') {
                        input.mark(32);
                        if ((c = input.read()) == '1') {
                                System.out.println("Server Quits.");
                                ds.close();
                                return;
                        } else {
                            input.reset();
                            c = '-';
                            buffer[pos++] = (byte) c;
                        }
                    } else {
                        buffer[pos++] = (byte) c;
                    }
            }
        }
    }

    public static void TheClient() throws IOException {
        while (true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
        }
    }

    public static void main(String[] args) throws IOException {

        if (args.length == 1) {
            ds = new DatagramSocket(serverPort);
            TheServer();
        } else {
            ds = new DatagramSocket(clientPort);
            TheClient();
        }
    }
}

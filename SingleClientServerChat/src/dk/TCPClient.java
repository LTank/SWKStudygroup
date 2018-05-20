package dk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            // First I connect to the server
            System.out.println("Connecting to the server.. ");
            String ip = InetAddress.getLocalHost().getHostAddress(); // Step 1
            socket = new Socket(ip, 5555); // Step 2
            System.out.println("Connected.. ");

            // Step 2: Makes us able to receive, write & send messages
            // BufferedReader is used because of the .ready() function, which supports our wish of full-duplex
            // .ready() checks if the stream is ready to be read. Will be ready input/output is not empty.
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // PrinterWriter is used to print output, because it prints
            // formatted representations of objects to a text-output stream.
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Step 3
            String sendMessage = "";
            System.out.println("Time to chat - enter your messages!");
            while(!sendMessage.equalsIgnoreCase("Bye")) {
                if(input.ready()) {
                    System.out.println("Server: " + input.readLine());
                }

                if (keyboardReader.ready()) {
                    sendMessage = keyboardReader.readLine();
                    output.println(sendMessage);
                }
                Thread.sleep(250); // Minimizes ressource usage.
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        finally { // When the message "bye" is received, then this will trigger
            try {
                System.out.println("\n* Closing connection… *");
                socket.close(); //Step 4.
            }
            catch(IOException ioEx)
            {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}

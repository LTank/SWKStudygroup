package dk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {

        // Creating a socket here both to be used to define new ServerScoket & be able to close socket
        Socket socket = null;
        try {
            System.out.println("Creating the server.. ");
            // Step 1
            ServerSocket serverSocket = new ServerSocket(5555);

            // Step 2
            // .accept() blocks until it receives a connection from our client.
            socket = serverSocket.accept();
            System.out.println("Server created.. ");

            // Step 3
            // Buffered is used because of the .ready() function, which Scanner does not have
            // .ready() checks if the stream is ready to be read. Will be ready input/output is not empty.
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Makes us able to write messages
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // Step 4
            String sendMessage = "";
            String receiveMessage = "";
            while(!receiveMessage.equalsIgnoreCase("Bye")) {
                if(input.ready()) { // Checks if client messaged you and prints it if so
                    receiveMessage = input.readLine();
                    System.out.println("Client: " + receiveMessage);
                }

                if(keyboardReader.ready()){
                    // Makes server able to reply message
                    sendMessage = keyboardReader.readLine();
                    output.println(sendMessage);
                }
                Thread.sleep(250); // Minimizes ressource usage.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally // When the message "bye" is received, then this will trigger
        {
            try
            {
                System.out.println(
                        "\n* Closing connection… *");
                socket.close(); //Step 5
            }
            catch(IOException ioEx)
            {
                System.out.println(
                        "Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}

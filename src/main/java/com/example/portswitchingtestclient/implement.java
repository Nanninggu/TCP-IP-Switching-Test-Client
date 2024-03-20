package com.example.portswitchingtestclient;

import java.io.IOException;
import java.net.Socket;

public class implement {

    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int PORT_5160 = 5160;
        final int PORT_5200 = 5200;

        int currentPort = PORT_5200;

        while (true) {
            try {
                // Try to connect to the server
                Socket socket = new Socket(SERVER_ADDRESS, currentPort);
                System.out.println("Connected to port " + currentPort);
                // Do something with the socket if needed
                // ...
                // Close the socket
                socket.close();
            } catch (IOException e) {
                // Connection failed
                System.out.println("Connection to port " + currentPort + " failed.");

                // Switch port and retry
                if (currentPort == PORT_5200) {
                    currentPort = PORT_5160;
                } else {
                    currentPort = PORT_5200;
                }
            }

            // Sleep for a while before attempting the next connection
            try {
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.codehacks.ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws IOException {
        ServerSocket server_socket = new ServerSocket(2021);
        System.out.println("Port 2021 is open.");
        
        Socket socket = server_socket.accept();
        System.out.println("Client " + socket.getInetAddress() + " has connected.");
        
        // I/O buffers:
        BufferedReader in_socket = new BufferedReader(
                                    new InputStreamReader(socket.getInputStream()));
                                                // reads data from client
        PrintWriter out_socket = new PrintWriter(
                                    new OutputStreamWriter(socket.getOutputStream()), true);
        
        out_socket.println("Welcome to 2021!"); // Send "Welcome to the client
        String msg_from_client = in_socket.readLine();
        System.out.println("Client says: " + msg_from_client);  // Displays client's msg in console
        
        // close the socket
        socket.close();
        System.out.println("Socket is closed.");
    }
    
    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

package com.codehacks.ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    
    public Client() throws IOException  {
        Socket socket = new Socket("localhost", 2021);
        System.out.println("Successful connection to the server.");
        
        // I/O streams
        BufferedReader in_socket = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(socket.getOutputStream(), true);
        
        String msg = in_socket.readLine();
        System.out.println("Server says: " + msg);
        out_socket.println("Thanks!");
        
        socket.close();
        System.out.println("Socket closed.");
    }
    
    public static void main(String[] args) {
        
        try {
            new Client();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

package com.codehacks.multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            
            System.out.println("Client has connected.");
            
            // I/O Buffers
            BufferedReader in_socket = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            // reads data from client
            PrintWriter out_socket = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()), true);

            out_socket.println("Welcome to 2021, What's your name? "); // Send "Welcome to the client
            String msg_from_client = in_socket.readLine();
            System.out.println("Client says: " + msg_from_client);  // Displays client's msg in console

            // close the socket
            socket.close();
            System.out.println("Socket is closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

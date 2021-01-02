package com.codehacks.multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket socket;
    private ServerMain serverMain;

    public ServerThread(Socket socket, ServerMain main) {
        this.socket = socket;
        this.serverMain = main;
    }

    @Override
    public void run() {
        try {
            int client_num = serverMain.getClientNumber();
            System.out.println("Client " + client_num + " has connected.");
            
            // I/O Buffers
            BufferedReader in_socket = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            // reads data from client
            PrintWriter out_socket = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()), true);

            out_socket.println("Welcome, You are client " + client_num + ". What's your name? "); // Send "Welcome to the client
            String msg_from_client = in_socket.readLine();
            System.out.println("Client says: " + msg_from_client);  // Displays client's msg in console

            // close the socket
            socket.close();
            System.out.println("Client " + client_num + " has disconnected.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

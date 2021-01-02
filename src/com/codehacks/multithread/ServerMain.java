package com.codehacks.multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    
    private int clientNumber = 1;
    
    public ServerMain() throws IOException {
        
        ServerSocket server_socket = new ServerSocket(2021);
        System.out.println("Port 2021 is now open.");
        
        // infinte loop: wait for new connections
        while(true) {
            Socket socket = server_socket.accept();
            ServerThread server_thread = new ServerThread(socket, this);
            Thread thread = new Thread(server_thread);
            thread.start();
        }
    }
    
    public int getClientNumber() {
        return clientNumber++;
    }
    public static void main(String[] args) {
        try {
            new ServerMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

package com.codehacks.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() throws IOException {
        Socket socket = new Socket("localhost", 2021);
        System.out.println("Successful connection to the server.");

        // I/O streams
        BufferedReader in_socket = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(socket.getOutputStream(), true);
        Scanner keyboard = new Scanner(System.in);
        String user_number;
        
        /** message = in_socket.readLine();
        System.out.println("Server says: " + message);
        System.out.print("Say something to the server: ");
        message = keyboard.nextLine();      // user is prompted to type msg for server
        out_socket.println(message);
        */
        
        // Playing a game
        while(in_socket.readLine().startsWith("Guess")) {
            System.out.println("Server says: Guess number [1-10].");
            user_number = keyboard.nextLine();
            out_socket.println(user_number);
        }
        
        System.out.println("You got it!!!");
        
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

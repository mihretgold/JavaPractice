/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatappsockets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author bageg
 */
public class ChatServer {
    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream input;
    static DataOutputStream output;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Create a server socket
            serverSocket = new ServerSocket(1201);
            System.out.println("Server started");

            // Accept client connection
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Get the input and output streams
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            String message = "";
            while (!message.equals("Exit")) {

                // Receive the message from the client
                message = input.readUTF();
                System.out.println("Client: " + message);

                System.out.print("Enter message: ");
                String reply = scanner.nextLine();

                // Send the reply to the client
                output.writeUTF(reply);
            }

            // Close the connection
            socket.close();
            input.close();
            output.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatappsockets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author bageg
 */
public class ChatAppSockets {
static Socket socket;
    static DataInputStream input;
    static DataOutputStream output;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Establish a connection
            socket = new Socket("127.0.0.1", 1201);
            System.out.println("Connected to server");

            // Get the input and output streams
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            String message = "";
            while (!message.equals("Exit")) {
                System.out.print("Enter message: ");
                message = scanner.nextLine();

                // Send the message to the server
                output.writeUTF(message);

                // Receive the message from the server
                String receivedMessage = input.readUTF();
                System.out.println("Server: " + receivedMessage);
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

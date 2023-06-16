/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package welcomeserver;

/**
 *
 * @author bageg
 */
import java.io.*;
import java.net.*;

public class WelcomeClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5678);
             BufferedReader input =
                     new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output =
                     new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput =
                     new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to welcome server");

            // Receive welcome message from server
            String welcomeMessage = input.readLine();
            System.out.println("Server: " + welcomeMessage);

            // Send message to server and receive response
            System.out.print("Enter a message to send to the server: ");
            String message = consoleInput.readLine();
            output.println(message);

            String response = input.readLine();
            System.out.println("Server: " + response);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

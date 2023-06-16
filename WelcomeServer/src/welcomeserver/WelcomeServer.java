/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package welcomeserver;

/**
 *
 * @author bageg
 */
import java.io.*;
import java.net.*;

public class WelcomeServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5678)) {
            System.out.println("Welcome server started on port 5678");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                try (PrintWriter output =
                             new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader input =
                             new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    // Send welcome message to client
                    output.println("Welcome to the server!");

                    // Read message from client and send length of message
                    String message;
                    while ((message = input.readLine()) != null) {
                        output.println("Your message has " + message.length() + " characters.");
                        break;
                    }
                } catch (IOException e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (IOException e){
            System.err.println("Could not start welcome server on port 5678: " + e.getMessage());
        }
    }
}
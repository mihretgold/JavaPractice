/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stringserver;

/**
 *
 * @author bageg
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class StringClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234);
             BufferedReader input =
                     new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output =
                     new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to string server");

            // Send message to server and receive response
            System.out.print("Enter a string to send to the server: ");
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String message = consoleInput.readLine();
            output.println(message);

            String response = input.readLine();
            System.out.println("Server response: " + response);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
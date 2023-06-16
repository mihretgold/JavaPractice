/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stringserver;

/**
 *
 * @author bageg
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class StringServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("String server started on port 1234");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                Scanner scanner = new Scanner(clientSocket.getInputStream());
                String message = scanner.nextLine();

                StringBuilder reversedMessage = new StringBuilder(message).reverse();
                clientSocket.getOutputStream().write(reversedMessage.toString().getBytes());

                scanner.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
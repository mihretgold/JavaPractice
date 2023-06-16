/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package timeserver;

/**
 *
 * @author bageg
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234);
             BufferedReader input =
                     new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output =
                     new PrintWriter(socket.getOutputStream(),true);
             BufferedReader consoleInput =
                     new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to time server");

            // Send message to server and receive response
            System.out.print("Press enter to get the current time: ");
            consoleInput.readLine();
            output.println("get_time");

            String response = input.readLine();
            System.out.println("Server: " + response);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

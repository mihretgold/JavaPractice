/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package userinputthread;

/**
 *
 * @author bageg
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputThread {
    public static void main(String[] args) {
        Thread userInputThread = new Thread(new UserInputHandler());
        userInputThread.start();

        try {
            userInputThread.join();
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static class UserInputHandler implements Runnable {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input;

            try {
                while ((input = reader.readLine()) != null) {
                    if (input.equals("exit")) {
                        break;
                    }

                    System.out.println("User input: " + input);
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
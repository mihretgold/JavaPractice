/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatAppThread;

/**
 *
 * @author bageg
 */
import java.io.*;
import java.net.*;
import static java.lang.System.out;

public class ChatClient {

    private String uname;
    private PrintWriter pw;
    private BufferedReader br;
    private Socket client;

    public ChatClient(String uname, String servername) throws Exception {
        this.uname = uname;
        client = new Socket(servername, 9999);
        br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        pw = new PrintWriter(client.getOutputStream(), true);
        pw.println(uname); // send name to server
        new MessagesThread().start(); // create thread to listen for messages
    }

    public void sendMessage(String message) {
        pw.println(message);
    }

    public void exit() {
        pw.println("end");
    }

    public static void main(String... args) {
        String name = null;
        String servername = "localhost";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter your name: ");
            name = reader.readLine();
            ChatClient client = new ChatClient(name, servername);

            System.out.println("Welcome to the chat server, " + name + "!");
            System.out.println("Type 'exit' to leave the chat.");

            while (true) {
                String message = reader.readLine();
                if (message.equalsIgnoreCase("exit")) {
                    client.exit();
                    break;
                }
                client.sendMessage(message);
            }
        } catch (Exception ex) {
            out.println("Error --> " + ex.getMessage());
        }
    }

    class MessagesThread extends Thread {
        public void run() {
            String line;
            try {
                while (true) {
                    line = br.readLine();
                    if (line.startsWith(uname + ": ")) {
                        // don't print messages sent by this client
                        continue;
                    }
                    out.println(line);
                }
            } catch (Exception ex) {
            }
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatAppThread;

/**
 *
 * @author bageg
 */
import java.io.*;
import java.net.*;
import java.util.*;
import static java.lang.System.out;

public class ChatServer {
    Vector<String> users = new Vector<String>();
    Vector<HandleClient> clients = new Vector<HandleClient>();

    public void process() throws Exception {
        ServerSocket server = new ServerSocket(9999, 10);
        out.println("Server Started...");
        while (true) {
            Socket client = server.accept();
            HandleClient c = new HandleClient(client);
            clients.add(c);
        } // end of while
    }

    public static void main(String... args) throws Exception {
        new ChatServer().process();
    } // end of main

    public void broadcast(String user, String message) {
        // send message to all connected users
        for (HandleClient c : clients)
            if (!c.getUserName().equals(user))
                c.sendMessage(user, message);
    }

    class HandleClient extends Thread {
        String name = "";
        BufferedReader input;
        PrintWriter output;

        public HandleClient(Socket client) throws Exception {
            // get input and output streams
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            output = new PrintWriter(client.getOutputStream(), true);
            // read name
            name = input.readLine();
            users.add(name); // add tovector
            start();
        }

        public void sendMessage(String uname, String msg) {
            output.println(uname + ":" + msg);
        }

        public String getUserName() {
            return name;
        }

        public void run() {
            String line;
            try {
                while (true) {
                    line = input.readLine();
                    if (line.equals("end")) {
                        clients.remove(this);
                        users.remove(name);
                        break;
                    }
                    broadcast(name, line);
                }
            } catch (Exception ex) {
                out.println(ex.getMessage());
            }
        }
    }
}
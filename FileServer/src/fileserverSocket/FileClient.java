/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileserverSocket;

/**
 *
 * @author bageg
 */

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class FileClient {
     public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server: " + socket.getInetAddress());

        InputStream in = socket.getInputStream();
        if (in == null) {
            System.err.println("File not found on server.");
            return;
        }
        FileOutputStream out = new FileOutputStream("file.txt");

        byte[] buffer = new byte[4096];
        int bytesRead;
        int totalBytesRead = 0;

        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
            totalBytesRead += bytesRead;
        }

        in.close();
        out.close();
        socket.close();

        System.out.println("File downloaded successfully.");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

/**
 *
 * @author bageg
 */

/*
    Algo
1) create a socket object with localhost and port number as a parameter 
2) print address of client socket
3) create input and output stream
4) initialize a string message to send to server
5) convert the message in to bytes using message.getBytes();
6) initialize a integer byteRead with in.read(buffer);
7) change byte to string and print string
8) close socket
*/
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args){
        try{
            Socket socket = new Socket("localhost", 1234);
            System.out.println(socket.getRemoteSocketAddress());
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            String message = "Hello Mihret";
            byte[] buffer = message.getBytes();
            out.write(buffer);
            System.out.println(message);
            buffer = new byte[1024];
            int byteRead = in.read(buffer);
            String response = new String(buffer, 0, byteRead);
            System.out.println(response);

            socket.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
   
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TCP;

/**
 *
 * @author bageg
 */
/*
    Algo
1) import java.io(for inputstream and output stream)
2) on the main function on make a try catch catching IO exception
3) create a ServerSocket object and pass a port number to the constructor
4) print the server to verify using server.getLocalPort();
5) When a client attempts to connect the server accepts connection using server.accept(); 
6) then we put the accepted port on a new socket object
7) then to verify we pring client.getRemoteSocketAddress();
8) then we create an input and output stream using client.getOutputSteam(); and .getInputStream();
9) create a buffer array of byte to read and write
10) read file using in.read(buffer) != -1
11) then print the read using out.write(buffer, 0, bytesRead)
12) print after converting bytes to string using new String(buffer, 0, bytesRead);
13) close client and socket


*/
import java.io.*;
import java.net.*;

public class TCPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ServerSocket socketServer = new ServerSocket(1234);
            System.out.println(socketServer.getLocalPort());
            Socket clientServer = socketServer.accept();
            System.out.println(clientServer.getRemoteSocketAddress());
            
            InputStream in = clientServer.getInputStream();
            OutputStream out = clientServer.getOutputStream();
            
            byte[] buffer = new byte[1024];
            int byteRead;
            
            while((byteRead = in.read(buffer)) != -1){
                out.write(buffer, 0, byteRead);
                System.out.println(new String(buffer, 0, byteRead));
            }
            socketServer.close();
            clientServer.close();
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}

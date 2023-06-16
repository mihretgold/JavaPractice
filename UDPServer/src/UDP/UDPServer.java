/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UDP;

/**
 *
 * @author bageg
 */
/*
    Algo
1) create a DatagramSocket object passing the port number to the constructor
2) print local port toc check
3) declare a reciveData byte array
4) create a DatagramPacket object withe reciveData and reciveData.length as parametes
5) while wating for incoming packet
6) recive packet with server.recive(recivePacket);
7) then extract data from the packet
    7.1) create a message string to accept data withe recivePacket.getData();
8) get address and port of client to print
9) send a response to client 
    9.1 createa response string and make it byte
    9.2 make a DatagramPacket object to send data
    9.3 send withe server.send(datagramobject)


*/
import java.io.*;
import java.net.*;

public class UDPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            DatagramSocket serverSocket = new DatagramSocket(1234);
            System.out.println(serverSocket.getPort());
            byte[] reciveData = new byte[1024];
            DatagramPacket recivePacket = new DatagramPacket(reciveData, reciveData.length);
            while(true){
                serverSocket.receive(recivePacket);
                String message = new String(recivePacket.getData(), 0, recivePacket.getLength());
                InetAddress clientAddress = recivePacket.getAddress();
                int clientPort = recivePacket.getPort();
                System.out.println("Recived message: " + message + " from " + clientAddress + ":" + clientPort);
                String response = "Hello Mihret";
                byte[] sendByte = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendByte, sendByte.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
                System.out.println("Sent message: " + response + " to " + clientAddress + ":" + clientPort); 
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}

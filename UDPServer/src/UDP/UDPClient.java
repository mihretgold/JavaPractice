/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

/**
 *
 * @author bageg
 */

/*
    Algo
1) create a DatagramSocket object passing no parameters
2) initialize a messeage string to send and make it byte arr
3) get the address of localhost and assign port to serveres port number
4) make a DatagramPacket to send server.send(datagramPacket) then print a message
5) create a byte array and DatagramPacket object to recive 
6) server.recive(datagramPacket)
7) make the byte a string, get address address and port print message
8) close server

*/

import java.io.*;
import java.net.*;


public class UDPClient {
    public static void main(String[] args){
        try{
            DatagramSocket clientSocket = new DatagramSocket();
            String message = "Hello mate";
            byte[] sendByte = message.getBytes();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int port = 1234;
            DatagramPacket sendPacket = new DatagramPacket(sendByte, sendByte.length, serverAddress, port);
            clientSocket.send(sendPacket);
            System.out.println("Message Sent to: " +  serverAddress + ":" + port);
            
            byte[] reciveByte = new byte[1024];
            DatagramPacket recivePacket = new DatagramPacket(reciveByte, reciveByte.length);
            clientSocket.receive(recivePacket);
            String response = new String(recivePacket.getData(), 0, recivePacket.getLength());
            InetAddress address = recivePacket.getAddress();
            int Sport = recivePacket.getPort();
            System.out.println("Message recived from" + address + ":" + port);
            clientSocket.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

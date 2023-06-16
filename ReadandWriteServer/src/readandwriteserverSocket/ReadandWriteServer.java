/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package readandwriteserverSocket;

/**
 *
 * @author bageg
 */
import java.io.*;
import java.net.*;
public class ReadandWriteServer {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
    try {
      ServerSocket ss = new ServerSocket(3333);
      Socket s = ss.accept();
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String str="", str2="";
      while(!str.equals("stop")){
        str=din.readUTF();
        System.out.println("Client says " + str);
        str2 = br.readLine();
        dout.writeUTF(str2);
        dout.flush();
      }
      din.close();
      s.close();
      ss.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package readandwriteserverSocket;

/**
 *
 * @author bageg
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ReadandWriteClient {
    public static void main(String[] args) {
    try {
      Socket s = new Socket("localhost", 3333);
      DataInputStream din=new DataInputStream(s.getInputStream());  
      DataOutputStream dout=new DataOutputStream(s.getOutputStream());
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String str="", str2="";
      while(!str.equals("stop")){
        str = br.readLine();
        dout.writeUTF(str);
        dout.flush();
        str2 = din.readUTF();
        System.out.println("Server says " + str2);
      }

      dout.close();
      s.close();
    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}

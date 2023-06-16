/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTP;

/**
 *
 * @author bageg
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class FTPClient {
     public static void main(String[] args) throws IOException {
      Socket socket = null;
      PrintWriter out = null;

      try {
          socket = new Socket("localhost", 1234);
          out = new PrintWriter(socket.getOutputStream(), true);
      } catch (UnknownHostException e) {
          System.err.println("Don't know about host: localhost.");
          System.exit(1);
      } catch (IOException e) {
          System.err.println("Couldn't get I/O for the connection to: localhost.");
          System.exit(1);
      }

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.print("Enter file name: ");
      String fileName = br.readLine();

      out.println(fileName);

      FileInputStream fis = new FileInputStream(fileName);
      BufferedInputStream bis = new BufferedInputStream(fis);

      OutputStream os = socket.getOutputStream();
      BufferedOutputStream bos = new BufferedOutputStream(os);

      byte[] buffer = new byte[1024];
      int bytesRead;

      while ((bytesRead = bis.read(buffer, 0, buffer.length)) != -1) {
          bos.write(buffer, 0, bytesRead);
      }

      bos.flush();
      bos.close();

      System.out.println("File sent successfully.");

      socket.close();
  } 
}

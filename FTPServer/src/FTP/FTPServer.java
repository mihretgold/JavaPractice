/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FTP;

/**
 *
 * @author bageg
 */
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class FTPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
      ServerSocket serverSocket = null;
      Socket socket = null;

      try {
          serverSocket = new ServerSocket(1234);
      } catch (IOException e) {
          System.err.println("Could not listen on port: 1234.");
          System.exit(1);
      }

      System.out.println("Server started. Listening on port: 1234");

      try {
          socket = serverSocket.accept();
      } catch (IOException e) {
          System.err.println("Accept failed.");
          System.exit(1);
      }

      System.out.println("Connection established. Receiving file...");

      InputStream is = socket.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is));

      String fileName = br.readLine();
      System.out.println("File name received: " + fileName);

      FileOutputStream fos = new FileOutputStream(fileName);
      BufferedOutputStream bos = new BufferedOutputStream(fos);

      byte[] buffer = new byte[1024];
      int bytesRead;

      while ((bytesRead = is.read(buffer, 0, buffer.length)) != -1) {
          bos.write(buffer, 0, bytesRead);
      }

      bos.flush();
      bos.close();

      System.out.println("File received successfully.");

      socket.close();
     }
    
}

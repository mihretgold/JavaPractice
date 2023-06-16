/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author bageg
 */
public class JavaApplication7 {
//    public static void main(String[] args) {
//        try {
//            ServerSocket serverSocket = new ServerSocket(5678);
//            System.out.println("Server started on port 5678");
//            while (true) {
//                Socket clientSocket;
//                try {
//                    clientSocket = serverSocket.accept();
//                    System.out.println("Client connected: " + clientSocket.getInetAddress());
//                } catch (IOException ex) {
//                    Logger.getLogger(JavaApplication7.class.getName()).log(Level.SEVERE, null, ex);
//                    continue;
//                }
//
//                Socket serverSocket2;
//                try {
//                    serverSocket2 = new Socket("127.0.0.1", 8080);
//                    System.out.println("Connected to server at 127.0.0.1:8080");
//                } catch (IOException ex) {
//                    Logger.getLogger(JavaApplication7.class.getName()).log(Level.SEVERE, null, ex);
//                    continue;
//                }
//
//                ExecutorService executor = Executors.newFixedThreadPool(2);
//                executor.submit(() -> forwardData(clientSocket, serverSocket2));
//                executor.submit(() ->forwardData(serverSocket2, clientSocket));
//                executor.shutdown();
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(JavaApplication7.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//private static void forwardData(Socket sourceSocket, Socket destinationSocket) {
//    try {
//        InputStream input = sourceSocket.getInputStream();
//        OutputStream output = destinationSocket.getOutputStream();
//
//        byte[] buffer = new byte[1024];
//        int bytesRead;
//        while ((bytesRead = input.read(buffer)) != -1) {
//            output.write(buffer, 0, bytesRead);
//            output.flush();
//        }
//    } catch (IOException ex) {
//        Logger.getLogger(JavaApplication7.class.getName()).log(Level.SEVERE, null, ex);
//    } finally {
//        try {
//            sourceSocket.close();
//            destinationSocket.close();
//        } catch (IOException ex) {
//            Logger.getLogger(JavaApplication7.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//}
//How can you implement a server that handles multiple protocols (e.g. HTTP, WebSocket, and FTP)?//

//    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(1234);
//        Socket clientSocket;
//
//        while (true) {
//            clientSocket = serverSocket.accept();
//            String header = getHeader(clientSocket);
//            if (header.startsWith("GET / HTTP")) {
//                // Handle HTTP request
//                OutputStream output = clientSocket.getOutputStream();
//                output.write("HTTP/1.1 200 OK\r\n".getBytes());
//                output.write("Content-Type: text/html\r\n".getBytes());
//                output.write("\r\n".getBytes());
//                output.write("<html><body><h1>Hello, World!</h1></body></html>".getBytes());
//                output.flush();
//            } else if (header.startsWith("GET /websocket HTTP")) {
//                // Handle WebSocket request
//                OutputStream output = clientSocket.getOutputStream();
//                output.write("HTTP/1.1 101 Switching Protocols\r\n".getBytes());
//                output.write("Upgrade: websocket\r\n".getBytes());
//                output.write("Connection: Upgrade\r\n".getBytes());
//                output.write("\r\n".getBytes());
//                output.flush();
//
//                InputStream input = clientSocket.getInputStream();
//                byte[] buffer = new byte[1024];
//                int bytesRead;
//                while ((bytesRead = input.read(buffer)) != -1) {
//                    // Handle WebSocket data
//                }
//            } else if (header.startsWith("FTP")) {
//                // Handle FTP request
//            } else {
//                // Unsupported protocol
//            }
//        }
//    }

//    private static String getHeader(Socket socket) {
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String line;
//            StringBuilder header = new StringBuilder();
//            while ((line = reader.readLine()) != null && !line.isEmpty()) {
//                header.append(line).append("\r\n");
//            }
//            return header.toString();
//        } catch (IOException e) {
//            // Handle exception
//        }
//    }
////How can you implement a server that supports persistent connections?//

public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(1234);
    Socket clientSocket;
    while (true) {
    clientSocket = serverSocket.accept();
    String header = getHeader(clientSocket);
    if (header.startsWith("GET / HTTP")) {
        handleHTTP(clientSocket);
    }
}

}
private static String getHeader(Socket socket) {
    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        StringBuilder header = new StringBuilder();
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            header.append(line).append("\r\n");
        }
        return header.toString();
    } catch (IOException e) {
        // Handle exception
        
    }
    return null;
}



private static void handleHTTP(Socket socket) {
    try {
        OutputStream os = socket.getOutputStream();
        String response = "HTTP/1.1 200 OK\r\nContent-Length: 13\r\nConnection: keep-alive\r\n\r\nHello, world!";
        os.write(response.getBytes());
        os.flush();
    } catch (IOException e) {
        // Handle exception
    }
}
////How can you implement a server that supports load testing?//
//Socket socket = new Socket("127.0.0.1", 1234);
//OutputStream os = socket.getOutputStream();
//InputStream is = socket.getInputStream();
//
//for (int i = 0; i < 1000; i++) {
//    String request = "GET / HTTP/1.1\r\nHost: localhost\r\n\r\n";
//    os.write(request.getBytes());
//    os.flush();
//
//    byte[] buffer = new byte[1024];
//    int length = is.read(buffer);
//    String response = new String(buffer, 0, length);
//    // Verify response
//}
//
//socket.close();
////How can you implement a server that uses SSL/TLS encryption?//
//KeyStore keyStore = KeyStore.getInstance("JKS");
//keyStore.load(new FileInputStream("keystore.jks"), "password".toCharArray());
//
//KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//kmf.init(keyOops, it seems like my previous message got cut off. Here's the complete answer to question 5:
//
//```java
//KeyStore keyStore = KeyStore.getInstance("JKS");
//keyStore.load(new FileInputStream("keystore.jks"), "password".toCharArray());
//
//KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//kmf.init(keyStore, "password".toCharArray());
//
//SSLContext sslContext = SSLContext.getInstance("TLS");
//sslContext.init(kmf.getKeyManagers(), null, null);
//
//ServerSocketFactory ssf = sslContext.getServerSocketFactory();
//ServerSocket serverSocket = ssf.createServerSocket(1234);
//
//Socket socket = serverSocket.accept();
//// Use socket to interact with client over SSL/TLS
////How can you create a simple TCP server in Java?
//ServerSocket serverSocket = new ServerSocket(1234);
//Socket clientSocket;
//
//while (true) {
//    clientSocket = serverSocket.accept();
//    // Use clientSocket to interact with client
//}
////How can you create a simple TCP client in Java?
//Socket socket = new Socket("localhost", 1234);
//// Use socket to interact with server
////How can you implement a simple chat application using sockets in Java?
//// Server code
//ServerSocket serverSocket = new ServerSocket(1234);
//Socket// Server code
//ServerSocket serverSocket = new ServerSocket(1234);
//Socket clientSocket;
//
//while (true) {
//    clientSocket = serverSocket.accept();
//    new Thread(() -> handleClient(clientSocket)).start();
//}
//
//private static void handleClient(Socket socket) {
//    try {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            System.out.println("[Client " + socket.getRemoteSocketAddress() + "]: " + line);
//        }
//        socket.close();
//    } catch (IOException e) {
//        // Handle exception
//    }
//}
//
//// Client code
//Socket socket = new Socket("localhost", 1234);
//PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
//
//Scanner scanner = new Scanner(System.in);
//String line;
//while ((line = scanner.nextLine()) != null) {
//    writer.println(line);
//}
////How can you implement a simple file transfer application using sockets in Java?
//// Server code
//ServerSocket serverSocket = new ServerSocket(1234);
//Socket clientSocket;
//
//while (true) {
//    clientSocket = serverSocket.accept();
//    new Thread(() -> handleClient(clientSocket)).start();
//}
//
//private static void handleClient(Socket socket) {
//    try {
//        InputStream is = socket.getInputStream();
//        OutputStream os = new FileOutputStream("file.txt");
//        byte[] buffer = new byte[1024];
//        int length;
//        while ((length = is.read(buffer)) > 0) {
//            os.write(buffer, 0, length);
//        }
//        os.close();
//        socket.close();
//    } catch (IOException e) {
//        // Handle exception
//    }
//}
//
//// Client code
//Socket socket = new Socket("localhost", 1234);
//InputStream is = new FileInputStream("file.txt");
//byte[] buffer = new byte[1024];
//int length;
//while ((length = is.read(buffer)) > 0) {
//    socket.getOutputStream().write(buffer, 0, length);
//}
//socket.close();
////How can you implement a simple multi-client chat server using sockets in Java?
//// Server code
//ServerSocket serverSocket = new ServerSocket(1234);
//List<Socket> clients = new ArrayList<>();
//
//while (true) {
//    Socket clientSocket = serverSocket.accept();
//    clients.add(clientSocket);
//    new Thread(() -> handleClient(clientSocket, clients)).start();
//}
//
//private static void handleClient(Socket socket, List<Socket> clients) {
//    try {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            for (Socket client : clients) {
//                if (client != socket) {
//                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
//                    writer.println("[Client " + socket.getRemoteSocketAddress() + "]: " + line);
//                }
//            }
//        }
//        socket.close();
//        clients.remove(socket);
//    } catch (IOException e) {
//        // Handle exception
//    }
//}
//
//// Client code
//Socket socket = new Socket("localhost", 1234);
//PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
//
//Scanner scanner = new Scanner(System.in);
//String line;
//while ((line= scanner.nextLine()) != null) {
//    writer.println(line);
//}
//    
//    public static void main(String[] args) {
//        // TODO code application logic here
//    }
//    

//    public JavaApplication7() {
//        this.serverSocket = new ServerSocket(1234);
//    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employee;
import java.sql.*;

/**
 *
 * @author bageg
 */
//public class DatabaseConnection {
////     private static final String username = "root";
////    private static final String password = "@Bcd";
////    private static final String dataConn = "jdbc:mysql://localhost:3306/employee";
////    
////    private static Connection con = null;
////    
////    public static Connection getConnection(){
////        try { 
////            Class.forName("com.mysql.cj.jdbc.Driver");
////            con = DriverManager.getConnection(dataConn, username, password);
////            
////        } catch (Exception ex) {
////            System.out.println(ex.getMessage());
////        }
////        return con;
////    }
//    
//}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/employee";
            String user = "root";
            String password = "@Bcd";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established.");
        }
        return connection;
    }
}

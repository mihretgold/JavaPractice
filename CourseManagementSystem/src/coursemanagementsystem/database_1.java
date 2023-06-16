/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;
import java.sql.*;

/**
 *
 * @author bageg
 */
public class database_1 {
    public static Connection connectDb(){
        try{
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management", "root", "@Bcd");
            return conn;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

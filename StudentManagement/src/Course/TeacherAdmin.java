/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Course;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*public class student_admin {
  Connection con = MyConnection.getConnection();
  PreparedStatement ps;
  //get table max row
  public int getMax(){
      int id = 0;
      Statement st;
      try {
          st = con.createStatement();
          ResultSet rs = st.executeQuery("select max(id) from student");
          while(rs.next()){
              id = rs.getInt(1);
          }
      } catch (SQLException ex) {
          Logger.getLogger(student_admin.class.getName()).log(Level.SEVERE, null, ex);
      }
      return id + 1;
  }
  
  //insert data into student table
  public void insert(int id, String sname, String gender, String email, String phone, String fatherName, String motherName, String address){
     String sql = "insert into student values(?,?,?,?,?,?,?,?)";
      try {
          ps = con.prepareStatement(sql);
          ps.setInt(1,id);
          ps.setString(2,sname);
          ps.setString(3,gender);
          ps.setString(4,email);
          ps.setString(5,phone);
          ps.setString(6,fatherName);
          ps.setString(7,motherName);
          ps.setString(8,address);
          
          if(ps.executeUpdate() > 0){
              JOptionPane.showMessageDialog(null,"New Student added Successfully");
          }
          
      } catch (SQLException ex) {
          Logger.getLogger(student_admin.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
     //check student email address already exixts
     public boolean isEmailExist(String email){
      try {
          ps = con.prepareStatement("select * from student where email = ?");
          ps.setString(1, email);
          ResultSet rs = ps.executeQuery();
          if(rs.next()){
              return true;
          }
      } catch (SQLException ex) {
          Logger.getLogger(student_admin.class.getName()).log(Level.SEVERE, null, ex);
      }
         return false;
     }
     //check student phone address is already exist
     public boolean isPhoneExist(String phone){
      try {
          ps = con.prepareStatement("select * from student where phone = ?");
          ps.setString(1, phone);
          ResultSet rs = ps.executeQuery();
          if(rs.next()){
              return true;
          }
      } catch (SQLException ex) {
          Logger.getLogger(student_admin.class.getName()).log(Level.SEVERE, null, ex);
      }
         return false;
     }
     
//     get all student values from database student table
     
}
*/
/**
 *
 * @author bageg
 */
public class TeacherAdmin {
    Connection con = MyConnection.getConnection();
  PreparedStatement ps;
  //get table max row
  public int getMax(){
      int teacherid = 0;
      Statement st;
      try {
          st = con.createStatement();
          ResultSet rs = st.executeQuery("select max(teacherid) from teacher");
          while(rs.next()){
              teacherid = rs.getInt(1);
          }
      } catch (SQLException ex) {
          Logger.getLogger(student_admin.class.getName()).log(Level.SEVERE, null, ex);
      }
      return teacherid + 1;
    }
  //Insert to teacher 
  public void insert(int id, String sname, String gender, String email, String phone, String address, String course){
     String sql = "insert into teacher values(?,?,?,?,?,?,?)";
      try {
          ps = con.prepareStatement(sql);
          ps.setInt(1,id);
          ps.setString(2,sname);
          ps.setString(3,gender);
          ps.setString(4,email);
          ps.setString(5,phone);
          ps.setString(6,address);
          ps.setString(7,course);
          
          
          if(ps.executeUpdate() > 0){
              JOptionPane.showMessageDialog(null,"New Teacher added Successfully");
          }
          
      } catch (SQLException ex) {
          Logger.getLogger(student_admin.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  //check teacher email address already exixts
     public boolean isEmailExist(String email){
      try {
          ps = con.prepareStatement("select * from teacher where email = ?");
          ps.setString(1, email);
          ResultSet rs = ps.executeQuery();
          if(rs.next()){
              return true;
          }
      } catch (SQLException ex) {
          Logger.getLogger(student_admin.class.getName()).log(Level.SEVERE, null, ex);
      }
         return false;
     }
     //check student phone address is already exist
     public boolean isPhoneExist(String phone){
      try {
          ps = con.prepareStatement("select * from teacher where phone = ?");
          ps.setString(1, phone);
          ResultSet rs = ps.executeQuery();
          if(rs.next()){
              return true;
          }
      } catch (SQLException ex) {
          Logger.getLogger(student_admin.class.getName()).log(Level.SEVERE, null, ex);
      }
         return false;
     }
     public boolean isCourseExist(String course){
      try {
          ps = con.prepareStatement("select * from teacher where Course = ?");
          ps.setString(1, course);
          ResultSet rs = ps.executeQuery();
          if(rs.next()){
              return true;
          }
      } catch (SQLException ex) {
          Logger.getLogger(student_admin.class.getName()).log(Level.SEVERE, null, ex);
      }
         return false;
     }
}

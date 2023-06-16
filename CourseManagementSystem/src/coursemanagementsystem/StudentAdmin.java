/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;
import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author bageg
 */
public class StudentAdmin {
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    
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
          Logger.getLogger(StudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
      }
      return id + 1;
  }
    
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
          Logger.getLogger(StudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
    
    public void getStudentValue(JTable table, String searchValue){
          String sql = "select * from student where concat(id,name,email,phone) like ? order by id desc";
         
         try {
             ps = con.prepareStatement(sql);
             ps.setString(1, "%"+searchValue+"%");
             ResultSet rs = ps.executeQuery();
             DefaultTableModel model = (DefaultTableModel) table.getModel();
             Object[] row;
             while(rs.next()){
                 row = new Object[8];
                 row[0] = rs.getInt(1);
                 row[1] = rs.getString(2);
                 row[2] = rs.getString(3);
                 row[3] = rs.getString(4);
                 row[4] = rs.getString(5);
                 row[5] = rs.getString(6);
                 row[6] = rs.getString(7);
                 row[7] = rs.getString(8);
                 model.addRow(row);
                 
                 

             }
         } catch(SQLException ex) {
             Logger.getLogger(StudentAdmin.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
    
    
}



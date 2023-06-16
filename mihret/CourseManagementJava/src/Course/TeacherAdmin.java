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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
           Logger.getLogger(TeacherAdmin.class.getName()).log(Level.SEVERE, null, ex);
      }
      return teacherid + 1;
    }
  //Insert to teacher 
  public void insert(int id, String sname, String gender, String email, String phone, String address, String password){
     String sql = "insert into teacher values(?,?,?,?,?,?,?)";
      try {
          ps = con.prepareStatement(sql);
          ps.setInt(1,id);
          ps.setString(2,sname);
          ps.setString(3,gender);
          ps.setString(4,email);
          ps.setString(5,phone);
          ps.setString(6,address);
          ps.setString(7,password);
          
          
          if(ps.executeUpdate() > 0){
              JOptionPane.showMessageDialog(null,"New Teacher added Successfully");
          }
          
      } catch (SQLException ex) {
           Logger.getLogger(TeacherAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(TeacherAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(TeacherAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(TeacherAdmin.class.getName()).log(Level.SEVERE, null, ex);
      }
         return false;
     }
     // get student value
   public void getTeacherValue(JTable table, String searchValue) {
        String sql = "select * from teacher where concat(teacherid,name,email,phone) like ? order by teacherid asc";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[8];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//     update teacher value

    public void update(int id, String tname, String gender, String email, String phone, String address, String course) {
        String sql = "update teacher set name=?,gender=?,email=?,phone=?,address=?,password=? where teacherid=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tname);
            ps.setString(2, gender);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setString(6, course);
            ps.setInt(7, id);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Teacher data updated successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//     check id

    public boolean isIdExist(int id) {
        try {
            ps = con.prepareStatement("select * from teacher where teacherid = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void delete(int id) {
        int yesorNo = JOptionPane.showConfirmDialog(null, "Teacher Data will be deleted!!!", "Teacher Delete", JOptionPane.OK_OPTION);
        if (yesorNo == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from assign_course where teacher_id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
                ps = con.prepareStatement("delete from teacher where teacherid=?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Teacher deleted successfully!!!");

                }
            } catch (SQLException ex) {
                 Logger.getLogger(TeacherAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}

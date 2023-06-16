/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Course;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bageg
 */
public class Course_Admin {
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    //get table max row

    public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(courseid) from course");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }

    //insert data into student table
    public void insert(int id, String courseName, int creditHour) {
        String sql = "insert into course values(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, courseName);
            ps.setInt(3, creditHour);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New Course added Successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Course_Admin.class.getName()).log(Level.SEVERE, null, ex);        }
    }



//     get all course values from database course table
    public void getCourseValue(JTable table, String searchValue) {
        String sql = "select * from course where concat(courseid,coursename,credit_hour) like ? order by courseid asc";

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
                row[2] = rs.getInt(3);
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//     update course value

    public void update(int id, String courseName, int creditHour) {
        String sql = "update course set coursename=?,credit_hour=? where courseid=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, courseName);
            ps.setInt(2, creditHour);
            ps.setInt(3, id);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Course data updated successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//     check id

    public boolean isIdExist(int id) {
        try {
            ps = con.prepareStatement("select * from course where courseid = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void delete(int id) {
        int yesorNo = JOptionPane.showConfirmDialog(null, "Course Data will be deleted!!!", "Course Delete", JOptionPane.OK_OPTION);
        if (yesorNo == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from assign_course where course_id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
                ps = con.prepareStatement("delete from enroll_course where course_id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
                ps = con.prepareStatement("delete from course where courseid=?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Course deleted successfully!!!");

                }
            } catch (SQLException ex) {
                Logger.getLogger(Course_Admin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}

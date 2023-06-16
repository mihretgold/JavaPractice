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
public class EnrollCourse {
     Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    student_admin student = new student_admin();
    Course_Admin courses = new Course_Admin();
    //get table max row

    public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(enroll_id) from enroll_course");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }

    //insert data into student table
    public void insert(int id, int stud_id, int course_id) {
        if(!student.isIdExist(stud_id)){
            JOptionPane.showMessageDialog(null, "Student ID does not exist.");
            return;
        }
        if(!courses.isIdExist(course_id)){
            JOptionPane.showMessageDialog(null, "Course ID does not exist.");
            return;
        }
        
        String sql = "insert into enroll_course values(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, stud_id);
            ps.setInt(3, course_id);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New Student enrolled Successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnrollCourse.class.getName()).log(Level.SEVERE, null, ex);        }
    }



//     get all course values from database course table
    public void getEnrollValue(JTable table, String searchValue) {
        String sql = "select * from enroll_course where concat(enroll_id,id,course_id) like ? order by enroll_id asc";

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
            Logger.getLogger(EnrollCourse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//     update Enroll course value

    public void update(int id, int stud_id, int course_id){
        String sql = "update enroll_course set id=?,course_id=? where enroll_id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, stud_id);
            ps.setInt(2, course_id);
            ps.setInt(3, id);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Enroll Course data updated successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//     check id

    public boolean isIdExist(int id) {
        try {
            ps = con.prepareStatement("select * from enroll_course where enroll_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void delete(int id) {
        int yesorNo = JOptionPane.showConfirmDialog(null, "Enroll Course Data will be deleted!!!", "Course Delete", JOptionPane.OK_OPTION);
        if (yesorNo == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from enroll_course where enroll_id=?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Enrolled Course deleted successfully!!!");

                }
            } catch (SQLException ex) {
                Logger.getLogger(EnrollCourse.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Teacher;
import Course.Course_Admin;
import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;

/**
 *
 * @author bageg
 */
public class TeacherLogin {
      Connection con = MyConnection.getConnection();
    PreparedStatement ps;

//     get all operations values from database history table
    public void getTeacherCoursesAndStudents(JTable table, int teacherId) {
        String sql = "SELECT course.coursename AS course_name, enroll_course.id AS student_id, student.name AS student_name "
                + "FROM assign_course "
                + "JOIN course ON assign_course.course_id = course.courseid "
                + "JOIN enroll_course ON course.courseid = enroll_course.course_id "
                + "JOIN student ON enroll_course.id = student.id "
                + "WHERE assign_course.teacher_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, teacherId);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;

            while (rs.next()) {
                row = new Object[3];
                row[0] = rs.getString("course_name");
                row[1] = rs.getInt("student_id");
                row[2] = rs.getString("student_name");
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}


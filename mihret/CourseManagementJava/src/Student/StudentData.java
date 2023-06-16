/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Student;

import Course.Course_Admin;
import db.MyConnection;
import java.security.Timestamp;
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
import java.text.SimpleDateFormat;

/**
 *
 * @author bageg
 */
public class StudentData {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

//     get all operations values from database history table
    public void getHistoryValue(JTable table, int searchValue) {
        String sql = "SELECT course.coursename AS course_name, course.credit_hour, teacher.name AS teacher_name "
                + "FROM enroll_course "
                + "JOIN course ON enroll_course.course_id = course.courseid "
                + "JOIN assign_course ON course.courseid = assign_course.course_id "
                + "JOIN teacher ON assign_course.teacher_id = teacher.teacherid "
                + "WHERE enroll_course.id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, searchValue);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;

            while (rs.next()) {
                row = new Object[3];
                row[0] = rs.getString("course_name");
                row[1] = rs.getInt("credit_hour");
                row[2] = rs.getString("teacher_name");
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

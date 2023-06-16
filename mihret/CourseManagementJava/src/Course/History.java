/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Course;

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
public class History {
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    //get table max row

    public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(id) from history");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }

    //insert data into history table
    public void insert(String operations) {
        String sql = "insert into history (time, operation)values(CURRENT_TIMESTAMP,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, operations);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Data Saved");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Course_Admin.class.getName()).log(Level.SEVERE, null, ex);        }
    }



//     get all operations values from database history table
    public void getHistoryValue(JTable table, String searchValue) {
        String sql = "select * from history where concat(id,time,operation) like ? order by time asc";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[8];
                row[0] = rs.getInt(1);
                java.sql.Timestamp timestamp = rs.getTimestamp(2);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                row[1] = dateFormat.format(timestamp);
                row[2] = rs.getString(3);
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

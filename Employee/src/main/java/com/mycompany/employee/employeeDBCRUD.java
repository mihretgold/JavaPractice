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
public class employeeDBCRUD {
    public static void create(Employee person) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO employee (first_name, last_name, SSN) VALUES (?, ?, ?)")) {
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setString(3, person.getSSN());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
//    public static Employee read(int id) {
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(
//                     "SELECT * FROM employee WHERE id = ?")) {
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                Employee person = new Employee();
//                person.setId(resultSet.getInt("id"));
//                person.setFirstName(resultSet.getString("first_name"));
//                person.setLastName(resultSet.getString("last_name"));
//                return person;
//            } else {
//                return null;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
}

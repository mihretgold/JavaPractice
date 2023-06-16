/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bageg
 */
public abstract class Employee {

    private String firstName;
    private String lastName;
    private String SSN;
//    private int id;

    public Employee( String firstName, String lastName, String SSN){
//        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }
    public String to_String(){
        return "Emplyoyee";
    }

    public abstract Double earning();

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getSSN() {
        return this.SSN;
    }
    public abstract void create();
    public static void display() throws SQLException{
        Connection conn = null;
        conn = DatabaseConnection.getConnection();

        String sql = "SELECT * FROM employee";
        PreparedStatement statement = conn.prepareStatement(sql);
            
        // Execute the select statement and print the results
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int employeeId = resultSet.getInt("employee_id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String ssn = resultSet.getString("SSN");

            System.out.print("Employee ID: " + employeeId);
            System.out.print("\tFirst Name: " + firstName);
            System.out.print("\tLast Name: " + lastName);
            System.out.print("\tSSN: " + ssn);
        }
    }
    public static void delete(int id) throws SQLException{
        Connection conn = null;
        conn = DatabaseConnection.getConnection();

// Prepare the SQL statement to delete the employee with the specified ID
        String sql = "DELETE FROM employee WHERE employee_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        // Execute the delete statement and print the number of rows affected
        int rowsAffected = statement.executeUpdate();
        if(rowsAffected != 0){
        System.out.println(rowsAffected + " data is successfully deleted.");
        }
        else{
            System.out.println("No data is found!!");
        }
       
    }
    public static void edit(int id, String firstname, String lastname, String ssn) throws SQLException {
        Connection conn = null;
        conn = DatabaseConnection.getConnection();

// Prepare the SQL statement to update the employee with the specified ID
        String sql = "UPDATE employee SET firstname = ?, lastname = ?, SSN = ? WHERE employee_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, firstname);
        statement.setString(2, lastname);
        statement.setString(3, ssn);
        statement.setInt(4, id);

        // Execute the update statement and print the number of rows affected
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected != 0) {
            System.out.println(rowsAffected + " data is successfully updated.");
        } else {
            System.out.println("No data is found!!");
        }
        
    }

}

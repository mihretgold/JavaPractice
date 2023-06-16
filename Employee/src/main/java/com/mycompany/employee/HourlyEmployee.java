/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, String SSN, double wage, double hours) {
        super(firstName, lastName, SSN);
        this.hours = hours;
        this.wage = wage;
    }
    

    @Override
    public Double earning() {
        double result = 0;
        if(hours <= 40){
            result = wage * hours;
        }
        else if(hours > 40){
            result = 40 * wage +(hours - 40)*wage*1.5;
        }
        return result;
    }
    @Override
    public String to_String(){
        return "HourlyEmployee";
    }
    public void setHours(double hours){
        this.hours = hours;
    }
    public double getHours(){
        return this.hours;
    }
    public void setWage(double wage){
        this.wage = wage;
    }
    public double getWage(){
        return this.wage;
    }

    
    @Override
        public void create() {
        Connection connection = null;
        PreparedStatement statement = null;
        try{   
            //Create connection
            connection =  DatabaseConnection.getConnection();
            // Create Query
            String sql = "INSERT INTO employee (first_name, last_name, SSN) VALUES (?, ?, ?)";
            //Make preparedStatement
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            //set atributes on employee table
            statement.setString(1, getFirstName());
            statement.setString(2, getLastName());
            statement.setString(3, getSSN());
            statement.executeUpdate();
            
            //Get auto increamented id of employee table to link to salarid table
            ResultSet rs = statement.getGeneratedKeys();
            int employeeId = -1;
            if(rs.next()){
                employeeId = rs.getInt(1);
            }
            
            //create query for Hourly table
            sql = "INSERT into hourly_employee (id, wage, hours)VAlUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            
            //set attributes in Hourly 
            statement.setInt(1, employeeId);
            statement.setDouble(2, getWage());
            statement.setDouble(3, getHours());
            statement.executeUpdate();
            System.out.println("Hourly Added Successfully !!!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }    
    public static void displayAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // establish connection
            conn = DatabaseConnection.getConnection();

            // create query and prepared statement 
            String sql = "SELECT e.first_name, e.last_name, e.SSN, h.wage, h.hours FROM employee e JOIN hourly_employee h ON e.id = h.id";
            stmt = conn.prepareStatement(sql);

            // execute the prepared statement to select all rows from the salary_employee table
            ResultSet rs = stmt.executeQuery();

            // iterate over the result set and display each row
            while (rs.next()) {
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                String ssn = rs.getString("SSN");
                double wage = rs.getDouble("wage");
                double hours = rs.getDouble("hours");

                HourlyEmployee employee = new HourlyEmployee(firstname, lastname, ssn, wage, hours);
                System.out.println("First Name: " + firstname);
                System.out.println("Last Name: " + lastname);
                System.out.println("SSN: " + ssn);
                System.out.println("Wage: " + wage);
                System.out.println("Wage: " + hours);
            }
        } catch (SQLException ex) {
            System.out.println("Error while fetching SalaryEmployee data: " + ex.getMessage());
        } 
    }

//    @Override
//    public void read(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void update() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void delete() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
}

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
public class CommissionEmployee extends Employee {
    double commissionRate;
    double grossSales;

    public CommissionEmployee(String firstName, String lastName, String SSN, double commissionRate, double grossSales) {
        super(firstName, lastName, SSN);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    @Override
    public Double earning() {
        double result = commissionRate * grossSales;
        return result;
    }
    @Override
    public String to_String(){
        return "CommisssionEmployee";
    }
    public void setGrossSales(double grossSales){
        this.grossSales = grossSales;
    }
    public double getGrossSales(){
        return this.grossSales;
    }
    public void setCommissionRate(double commissionRate){
        this.commissionRate = commissionRate;
    }
    public double getCommissionRate(){
        return this.commissionRate;
    }

    public void setFirstNameSalar(String firstName){
        setFirstName(firstName);
    }

    public String getFirstNameSalar(){
        String getVal = getFirstName();
        return getVal;
    }
   
    public void setLastNameSalar(String lastName){
        setLastName(lastName);
    }

    public String getLastNameSalar(){
        String getVal = getLastName();
        return getVal;
    }

    public void setSSNSalar(String SSN) {
        setSSN(SSN);
    }

    public String getSSNSalar() {
        String getVal = getSSN();
        return getVal;
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
            sql = "INSERT into commission_employee (id, commission_rate, gross_sales)VAlUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            
            //set attributes in Hourly 
            statement.setInt(1, employeeId);
            statement.setDouble(2, getCommissionRate());
            statement.setDouble(3, getGrossSales());
            statement.executeUpdate();
            System.out.println("Commisions Added Successfully !!!");
            
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
            String sql = "SELECT e.first_name, e.last_name, e.SSN, c.commission_rate, c.gross_sales FROM employee e JOIN commission_employee c ON e.id = c.id";
            stmt = conn.prepareStatement(sql);

            // execute the prepared statement to select all rows from the salary_employee table
            ResultSet rs = stmt.executeQuery();

            // iterate over the result set and display each row
            while (rs.next()) {
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                String ssn = rs.getString("SSN");
                double commissionRate = rs.getDouble("commission_rate");
                double grossRate = rs.getDouble("gross_sales");

                CommissionEmployee employee = new CommissionEmployee(firstname, lastname, ssn, commissionRate, grossRate);
                System.out.println("First Name: " + firstname);
                System.out.println("Last Name: " + lastname);
                System.out.println("SSN: " + ssn);
                System.out.println("Wage: " + commissionRate);
                System.out.println("Wage: " + grossRate);
            }
        } catch (SQLException ex) {
            System.out.println("Error while fetching CommissionEmployee data: " + ex.getMessage());
        } 
    }
//
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
    
}

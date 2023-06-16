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
public class SalaridEmployee extends Employee {
    private double weeklySalary;
    
    public SalaridEmployee(String firstName, String lastName, String SSN, double weeklySalary) {
        super(firstName, lastName, SSN);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public Double earning() {        
        return weeklySalary;
    }
    @Override
    public String to_String(){
        return "SalaridEmployee";
    }
    public void setWeeklySalary(double weeklySalary){
        this.weeklySalary = weeklySalary;
    }
    public double getWeeklySalary(){
        return this.weeklySalary;
    }
  
 
//    DatabaseConnection.getConnection()
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
            
            //create query for salarid table
            sql = "INSERT into salarid_employee (id, weekly_salary)VAlUES (?, ?)";
            statement = connection.prepareStatement(sql);
            
            //set attributes in salarid 
            statement.setInt(1, employeeId);
            statement.setDouble(2, getWeeklySalary());
            statement.executeUpdate();
            System.out.println("Salarid Added Successfully !!!");
            
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
            String sql = "SELECT e.first_name, e.last_name, e.SSN, s.weekly_salary FROM employee e JOIN salarid_employee s ON e.id = s.id";
            stmt = conn.prepareStatement(sql);

            // execute the prepared statement to select all rows from the salary_employee table
            ResultSet rs = stmt.executeQuery();

            // iterate over the result set and display each row
            while (rs.next()) {
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                String ssn = rs.getString("SSN");
                double salary = rs.getDouble("weekly_salary");

                SalaridEmployee employee = new SalaridEmployee(firstname, lastname, ssn, salary);
                System.out.println("First Name: " + firstname);
                System.out.println("Last Name: " + lastname);
                System.out.println("SSN: " + ssn);
                System.out.println("WeeklySalary: " + salary);
            }
        } catch (SQLException ex) {
            System.out.println("Error while fetching SalaryEmployee data: " + ex.getMessage());
        } 
    }
    

    
    
}

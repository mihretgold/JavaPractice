/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employee;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author bageg
 */
public class Tester {
     public static void main(String[] args) {
         try {
            Connection connection = DatabaseConnection.getConnection();
            if (connection != null) {
                System.out.println("Connection established.");
            } else {
                System.out.println("Connection failed.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter SSN:");
        String SSN = scanner.nextLine();
//        System.out.println("Enter WeeklySalary:");
//        Double weekly = scanner.nextDouble();
//
//        SalaridEmployee employee = new SalaridEmployee(firstName, lastName, SSN, weekly);
//        employee.create();
//        employee.displayAll();

//        System.out.println("Enter Wage:");
//        Double wage = scanner.nextDouble();
//        System.out.println("Enter hours:");
//        Double hours = scanner.nextDouble();
//        HourlyEmployee employee = new HourlyEmployee(firstName, lastName, SSN, wage, hours);
//        employee.create();
//        employee.displayAll();
        System.out.println("Enter Commision rate:");
        Double commisionRate = scanner.nextDouble();
        System.out.println("Enter Gross sales:");
        Double grossSales = scanner.nextDouble();
        CommissionEmployee employee = new CommissionEmployee(firstName, lastName, SSN, commisionRate, grossSales);
        employee.create();
        employee.displayAll();
          
    }
}


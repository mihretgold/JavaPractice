/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employee;

/**
 *
 * @author bageg
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;
    public BasePlusCommissionEmployee(String firstName, String lastName, String SSN,double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, SSN, grossSales, commissionRate);
        this.baseSalary = baseSalary;
    }
    
    public Double earningBasePlus() {
        return earning() + baseSalary;
    }
    @Override
    public String to_String(){
        return "BasePlusCommisssionEmployee";
    }
    public void setBaseSalary(double baseSalary){
        this.baseSalary = baseSalary;
    }
    public double getBaseSalary(){
        return this.baseSalary;
    }
    public void setGrossSalesBase(double grossSales){
        setGrossSales(grossSales);
    }
    public double getGrossSalesBase(){
        double getVal = getGrossSales();
        return getVal;
    }
    public void setCommissionRateBase(double commissionRate){
       setCommissionRate(commissionRate);
    }
    public double getCommissionRateBase(){
        double getVal = getCommissionRate();
        return getVal;
    }

    @Override
    public void setFirstNameSalar(String firstName){
        setFirstName(firstName);
    }

    @Override
    public String getFirstNameSalar(){
        String getVal = getFirstName();
        return getVal;
    }
    @Override
    public void setLastNameSalar(String lastName){
        setLastName(lastName);
    }

    @Override
    public String getLastNameSalar(){
        String getVal = getLastName();
        return getVal;
    }

    @Override
    public void setSSNSalar(String SSN) {
        setSSN(SSN);
    }

    @Override
    public String getSSNSalar() {
        String getVal = getSSN();
        return getVal;
    }
    @Override
    public void create() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

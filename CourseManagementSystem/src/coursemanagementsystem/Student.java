/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author bageg
 */
public class Student extends Person{
  private final StringProperty id;
  private final StringProperty stname;
  private final StringProperty gender;
  private final StringProperty email;
  private final StringProperty phone;
  private final StringProperty fatherName;
  private final StringProperty motherName;
  private final StringProperty address;
 private Connection connect;
  private Statement statement;
  private PreparedStatement preapare;
  private ResultSet result;
  public Student(){
    id = new SimpleStringProperty(this, "id");
    stname = new SimpleStringProperty(this, "name");
    gender = new SimpleStringProperty(this, "gender");
    email = new SimpleStringProperty(this, "email");
    phone = new SimpleStringProperty(this, "phone");
    fatherName = new SimpleStringProperty(this, "father_name");
    motherName = new SimpleStringProperty(this, "mother_name");
    address = new SimpleStringProperty(this, "address");
  }
  
  public StringProperty idProperty() {
    return id;
  }
  public String getId(){
    return id.get();
  }
  public void setId(String newId) {
    id.set(newId);
  }

  public StringProperty stnameProperty() {
    return stname;
  }
  public String getStname(){
    return stname.get();
  }
  public void setStname(String newstname) {
    stname.set(newstname);
  }

  public StringProperty genderProperty() {
    return gender;
  }
  public String getGender(){
    return gender.get();
  }
  public void setGender(String newgender) {
    gender.set(newgender);
  }

  public StringProperty emailProperty() {
    return email;
  }
  public String getemail(){
    return email.get();
  }
  public void setemail(String newemail) {
    email.set(newemail);
  }

  public StringProperty phoneProperty() {
    return phone;
  }
  public String getphone(){
    return phone.get();
  }
  public void setphone(String newphone) {
    phone.set(newphone);
  }

  public StringProperty fatherNameProperty() {
    return fatherName;
  }
  public String getfatherName(){
    return fatherName.get();
  }
  public void setfatherName(String newfatherName) {
    fatherName.set(newfatherName);
  }

  public StringProperty motherNameProperty() {
    return motherName;
  }
  public String getmotherName(){
    return motherName.get();
  }
  public void setmotherName(String newmotherName) {
    motherName.set(newmotherName);
  }

  public StringProperty addressProperty() {
    return address;
  }
  public String getaddress(){
    return address.get();
  }
  public void setaddress(String newAddress) {
    address.set(newAddress);
  }
  
  

    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
    String setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
    String getPhoneNumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
    String setPhoneNumber(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
    String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
    String setEmail(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
    String getAddress() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
    String setAddress(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
}

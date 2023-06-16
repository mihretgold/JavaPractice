/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;

import db.MyConnection;
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
public class Teacher extends Person{
  private final StringProperty TeacherID;
  private final StringProperty TeacherName;
  private final StringProperty tGender;
  private final StringProperty Email;
  private final StringProperty phoneNo;
  private final StringProperty tAddress;
  private final StringProperty course;
  private Connection connect;
  private Statement statement;
  private PreparedStatement preapare;
  private ResultSet result;
    

  public Teacher(){
    TeacherID = new SimpleStringProperty(this, "TeacherID");
    TeacherName = new SimpleStringProperty(this, "TeacherName");
    tGender = new SimpleStringProperty(this, "tGender");
    Email = new SimpleStringProperty(this, "Email");
    phoneNo = new SimpleStringProperty(this, "phoneNo");
    tAddress = new SimpleStringProperty(this, "tAddress");
    course= new SimpleStringProperty(this, "course");
  }

  public StringProperty teacherIDProperty() {
    return TeacherID;
  }
  public String getTeacherID(){
    return TeacherID.get();
  }
  public void setTeacherID(String newId) {
    TeacherID.set(newId);
  }

  public StringProperty setTeacherNameProperty() {
    return TeacherName;
  }
  public String getTeacherName(){
    return TeacherName.get();
  }
  public void setTeacherName(String newstname) {
    TeacherName.set(newstname);
  }

  public StringProperty tGenderProperty() {
    return tGender;
  }
  public String getTGender(){
    return tGender.get();
  }
  public void setTGender(String newgender) {
    tGender.set(newgender);
  }

  public StringProperty EmailProperty() {
    return Email;
  }
  public String getEmail(){
    return Email.get();
  }
  public void setEmail(String newemail) {
    Email.set(newemail);
  }

  public StringProperty phoneNoProperty() {
    return phoneNo;
  }
  public String getphoneNo(){
    return phoneNo.get();
  }
  public void setphoneNo(String newphone) {
    phoneNo.set(newphone);
  }
  public StringProperty tAddressProperty() {
    return tAddress;
  }
  public String getTaddress(){
    return tAddress.get();
  }
  public void setTaddress(String newAddress) {
    tAddress.set(newAddress);
  }
  public StringProperty courseProperty() {
    return course;
  }
  public String getCourse(){
    return course.get();
  }
  public void setcourse(String newCourse) {
    course.set(newCourse);
  }
//  Connection con = MyConnection.getConnection();
//  PreparedStatement ps;
  //get table max row
  public int getMaxTeacher(){
      connect = database.connectDb();
      int id = 0;
      
      
      try {
          statement = connect.createStatement();
          result = statement.executeQuery("select max(teacherid) from teacher");
          while(result.next()){
              id = result.getInt(1);
          }
      } catch (SQLException ex) {
          Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
      }
      return id + 1;
  }
  //check student email address already exixts
     public boolean isEmailExist(String email){
         connect = database.connectDb();
      try {
          preapare = connect.prepareStatement("select * from teacher where email = ?");
          preapare.setString(1, email);
          result = preapare.executeQuery();
          if(result.next()){
              return true;
          }
      } catch (SQLException ex) {
          Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
      }
         return false;
     }
     //check student phone address is already exist
     public boolean isPhoneExist(String phone){
         connect = database.connectDb();
      try {
          preapare = connect.prepareStatement("select * from teacher where phone = ?");
          preapare.setString(1, phone);
          result = preapare.executeQuery();
          if(result.next()){
              return true;
          }
      } catch (SQLException ex) {
          Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
      }
         return false;
     }

}
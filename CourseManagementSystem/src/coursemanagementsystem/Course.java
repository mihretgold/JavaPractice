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
public class Course {
  private final StringProperty course_ID;
  private final StringProperty course_Name;
  private final StringProperty credit_Hour;
 
  private Connection connect;
  private Statement statement;
  private PreparedStatement preapare;
  private ResultSet result;
    
 

  public Course(){
    course_ID = new SimpleStringProperty(this, "course_ID");
    course_Name = new SimpleStringProperty(this, "course_Name");
    credit_Hour = new SimpleStringProperty(this, "credit_Hour");
   
  }

  public StringProperty courseIDProperty() {
    return course_ID;
  }
  public String getCourseID(){
    return course_ID.get();
  }
  public void setCourseID(String newId) {
    course_ID.set(newId);
  }

  public StringProperty CourseNameProperty() {
    return course_Name;
  }
  public String getCourseName(){
    return course_Name.get();
  }
  public void setCourseName(String newcoursename) {
    course_Name.set(newcoursename);
  }

  public StringProperty creditHourProperty() {
    return credit_Hour;
  }
  public String getCreditHour(){
    return credit_Hour.get();
  }
  public void setCreditHour(String newcredithour) {
    credit_Hour.set(newcredithour);
  }
  
   public int getMaxCourse(){
      connect = database.connectDb();
      int id = 0;
      
      
      try {
          statement = connect.createStatement();
          result = statement.executeQuery("select max(courseid) from course");
          while(result.next()){
              id = result.getInt(1);
          }
      } catch (SQLException ex) {
          Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
      }
      return id + 1;
  }
 
}
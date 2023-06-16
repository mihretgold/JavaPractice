/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coursemanagementsystem;

import db.MyConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.table.DefaultTableModel;

/**
 * FXML Controller class
 *
 * @author bageg
 */
public class StudentPageController implements Initializable {

    @FXML
    private Button addS;

    @FXML
    private TextField addressS;

    @FXML
    private Button clearS;

    @FXML
    private Button deleteS;

    @FXML
    private TextField emailS;

    @FXML
    private TextField fatherNameS;

    @FXML
    private TextField genderS;

    @FXML
    private Button homeS;

    @FXML
    private TextField motherNameS;

    @FXML
    private TextField phoneS;

    @FXML
    private TextField searchField;
    
    @FXML
    private Button studentBtn;

    @FXML
    private TextField studentId;

    @FXML
    private TextField studentName;
    
    @FXML
    private AnchorPane studentPg;

    @FXML
    private TableView<StudentData> table;

    @FXML
    private Button updateU;

    @FXML
    private TableColumn<StudentData, String> IDColumn;
    @FXML
    private TableColumn<StudentData, String> stnameColumn;
    @FXML
    private TableColumn<StudentData, String> genderColumn;
    @FXML
    private TableColumn<StudentData, String> emailColumn;
    @FXML
    private TableColumn<StudentData, String> phoneColumn;
    @FXML
    private TableColumn<StudentData, String> fatherNameColumn;
    @FXML
    private TableColumn<StudentData, String> motherNameColumn;
    @FXML
    private TableColumn<StudentData, String> addressColumn;

//    Connection con;
//    PreparedStatement pst;
//    ResultSet rs;
//    int myIndex;
//    int id;
    
    public void switchForm(ActionEvent event){
        
        if(event.getSource() == studentBtn){
            studentPg.setVisible(true);
            addStudentShowListData();
        }
        
    }
    
    
    private Connection connect;
    private Statement statement;
    private PreparedStatement preapare;
    private ResultSet result;
    
    
    
    StudentAdmin student = new StudentAdmin();

    
    
    public ObservableList<StudentData> addStudentListData() {
        ObservableList<StudentData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM student";
        

        connect = database.connectDb();
        try {
            preapare = connect.prepareStatement(sql);
            result = preapare.executeQuery();
            System.out.println("Result... "+result);
            StudentData students;

            while (result.next()) {
                students = new StudentData(result.getInt("id"),
                         result.getString("name"),
                         result.getString("gender"),
                         result.getString("email"),
                         result.getString("phone"),
                         result.getString("father_name"),
                         result.getString("mother_name"),
                         result.getString("address"));
                
                
                listData.add(students);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return listData;
    }

    private ObservableList<StudentData> addStudentList;
//    private ObservableList<StudentData> addStudentList = FXCollections.observableArrayList() ;

    public void addStudentShowListData() {
        addStudentList = addStudentListData();

        IDColumn.setCellValueFactory(new PropertyValueFactory<>("studId"));
        stnameColumn.setCellValueFactory(new PropertyValueFactory<>("studName"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("studGender"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("studEmail"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("studPhone"));
        fatherNameColumn.setCellValueFactory(new PropertyValueFactory<>("studFatherName"));
        motherNameColumn.setCellValueFactory(new PropertyValueFactory<>("studMotherName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("studAddress"));
        table.setItems(addStudentList);
    }

    public void addStudentSelect() {
        StudentData students = table.getSelectionModel().getSelectedItem();
        int num = table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        studentId.setText(String.valueOf(students.getStudentId()));
        studentName.setText(students.getStudentName());
        genderS.setText(students.getStudentGender());
        emailS.setText(students.getStudentEmail());
        phoneS.setText(students.getStudentPhone());
        fatherNameS.setText(students.getStudentFatherName());
        motherNameS.setText(students.getStudentMotherName());
        addressS.setText(students.getStudentAddress());
    }

    @FXML
    public void addStudent(ActionEvent event) {
        String sql = "INSERT INTO student "
                + "(id,name,gender,email,phone,father_name,mother_name,address)"
                + "VALUES(?,?,?,?,?,?,?,?)";
        connect = database.connectDb();
        try {

            Alert alert;
            if (studentId.getText().isEmpty()
                    || studentName.getText().isEmpty()
                    || genderS.getText().isEmpty()
                    || emailS.getText().isEmpty()
                    || phoneS.getText().isEmpty()
                    || fatherNameS.getText().isEmpty()
                    || motherNameS.getText().isEmpty()
                    || addressS.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String check = "SELECT id FROM student WHERE id ='"
                        + studentId.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student ID: " + studentId.getText() + " was already existent!");
                    alert.showAndWait();
                } else {

                    preapare = connect.prepareStatement(sql);
                    preapare.setString(1, studentId.getText());
                    preapare.setString(2, studentName.getText());
                    preapare.setString(3, genderS.getText());
                    preapare.setString(4, emailS.getText());
                    preapare.setString(5, phoneS.getText());
                    preapare.setString(6, fatherNameS.getText());
                    preapare.setString(7, motherNameS.getText());
                    preapare.setString(8, addressS.getText());
                    preapare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added");
                    alert.showAndWait();
                    
                    
                    addStudentShowListData();
                    clearStudent();
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void clearStudent() {
        studentId.setText(String.valueOf(student.getMax()));
        studentName.setText(null);
        genderS.setText(null);
        emailS.setText(null);
        phoneS.setText(null);
        fatherNameS.setText(null);
        motherNameS.setText(null);
        addressS.setText(null);
//        jTable1.clearSelection();           

    }

    @FXML
    void clearS(ActionEvent event) {
        clearStudent();
    }

    @FXML
    void course(ActionEvent event) {

    }

    @FXML
    void deleteStudent(ActionEvent event) {
        String sql = "DELETE FROM student WHERE id = '"
                + studentId.getText()+"'";
        
        connect = database.connectDb();
        
        try{
            
           Alert alert;
            if (studentId.getText().isEmpty()
                    || studentName.getText().isEmpty()
                    || genderS.getText().isEmpty()
                    || emailS.getText().isEmpty()
                    || phoneS.getText().isEmpty()
                    || fatherNameS.getText().isEmpty()
                    || motherNameS.getText().isEmpty()
                    || addressS.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Student ID: "+ studentId.getText()+"?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();
                    
                    addStudentShowListData();
                    clearStudent();
                }              
                
            } 
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void home(ActionEvent event) {

    }

    @FXML
    void logoutStudent(MouseEvent event) {

    }
    
    @FXML
    void searchStudent(MouseEvent event) {
        FilteredList<StudentData> filter = new FilteredList<>(addStudentList, e-> true);
        searchField.textProperty().addListener((Observable, oldValue, newValue) ->{
            
            filter.setPredicate(predicatestudentData ->{
              
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String searchKey = newValue.toLowerCase();
                
                if(predicatestudentData.getStudentId().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getStudentId().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getStudentName().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getStudentGender().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getStudentEmail().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getStudentPhone().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getStudentFatherName().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getStudentMotherName().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getStudentAddress().toString().contains(searchKey)){
                    return true;
                }
                else  return false;  
                    
                
            });
            
        });
       
        SortedList<StudentData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortList);
        
    }

    @FXML
    void teacher(ActionEvent event) {

    }

    @FXML
    void updateStudent(ActionEvent event) {
        
        String sql = "UPDATE student SET name ='"
                + studentName.getText() +"', gender = '"
                + genderS.getText() + "', email ='"
                + emailS.getText() + "', phone ='"
                + phoneS.getText() + "', father_name ='"
                + fatherNameS.getText() +"', mother_name ='"
                + motherNameS.getText() +"', address ='"
                + addressS.getText()+"'WHERE id ='" 
                + studentId.getText()+"'";
        connect = database.connectDb();
        
        try{
           
            Alert alert;
            if (studentId.getText().isEmpty()
                    || studentName.getText().isEmpty()
                    || genderS.getText().isEmpty()
                    || emailS.getText().isEmpty()
                    || phoneS.getText().isEmpty()
                    || fatherNameS.getText().isEmpty()
                    || motherNameS.getText().isEmpty()
                    || addressS.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Student ID: "+ studentId.getText()+"?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                    
                    addStudentShowListData();
                    clearStudent();
                }              
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addStudentShowListData();
        studentId.setText(String.valueOf(student.getMax()));
    }

}

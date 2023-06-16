/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coursemanagementsystem;

import Exceptions.InvalidPhoneNumberException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.Action;


/**
 * FXML Controller class
 *
 * @author bageg
 */
public class DashboardController implements Initializable {

     @FXML
    private TableColumn<Student, String> IDColumn;
    @FXML
    private TableColumn<Student, String> addressColumn;
    @FXML
    private TableColumn<Student, String> emailColumn;
    @FXML
    private TableColumn<Student, String> genderColumn;
    @FXML
    private TableColumn<Student, String> fatherNameColumn;
    @FXML
    private TableColumn<Student, String> motherNameColumn;
    @FXML
    private TableColumn<Student, String> phoneColumn;
    @FXML
    private TableColumn<Student, String> stnameColumn;    
    @FXML
    private TableView<Student> table;
    @FXML
    private TableColumn<Teacher, String> EmailColumn;
    @FXML
    private TableColumn<Teacher, String> courseColumn;
    @FXML
    private TableColumn<Teacher, String> phoneNoColumn;    
    @FXML
    private TableColumn<Teacher, String> tAddressColumn;
    @FXML
    private TableColumn<Teacher, String> tGenderColumn;    
    @FXML
    private TableColumn<Teacher, String> teacherIDColumn;
    @FXML
    private TableColumn<Teacher, String> teacherNameColumn;
    @FXML
    private TableView<Teacher> tTable;
    @FXML
    private TableView<Course> tableC;
    @FXML
    private TableColumn<Course, String> courseIDColumn;
    
    @FXML
    private TableColumn<Course, String> courseNameColumn;
    
    @FXML
    private TableColumn<Course, String> creditHourColumn;
    @FXML
    private TextField studentId;

    @FXML
    private TextField studentName;
    @FXML
    private TextField motherNameS;
    @FXML
    private TextField phoneS;
    @FXML
    private TextField addressS;

    @FXML
    private TextField genderS;

    @FXML
    private TextField emailS;


    @FXML
    private TextField fatherNameS;
     
    @FXML
    private Button close;
    @FXML
    private Button close1;
    @FXML
    private AnchorPane homePage;
    @FXML
    private AnchorPane studentPage;
    @FXML
    private Button addBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private AnchorPane studentPage11;
    @FXML
    private Button addBtn11;
    @FXML
    private Button updateBtn11;
    @FXML
    private Button deleteBtn11;
    @FXML
    private Button clearBtn11;
    @FXML
    private Button courseBtn;    
    @FXML
    private Button homeBtn;
    @FXML
    private AnchorPane coursePage;    
    @FXML
    private TextField searchField;
    @FXML
    private TextField searchTeachers;
    @FXML
    private Button studentBtn;
    @FXML
    private TextField teacherID;
    @FXML
    private TextField teacherName;
    @FXML
    private TextField teacherEmail;
    @FXML
    private TextField teacherPhone;
    @FXML
    private TextField teacherAddress;   
    @FXML
    private TextField teacherGender;
    @FXML
    private TextField searchCourses;
    @FXML
    private Button teacherBtn;    
    @FXML
    private AnchorPane teacherPage;
    @FXML
    private Button addBtn1;
    @FXML
    private Button updateBtn1;
    @FXML
    private Button deleteBtn1;
    @FXML
    private Button clearBtn1;    
    @FXML
    private TextField teacherCourse;
     @FXML
    private TextField courseID;
    @FXML
    private TextField courseName;
    @FXML
    private TextField creditHour;
    @FXML
    private Label homeTotalCourses;

    @FXML
    private Label homeTotalStudents;

    @FXML
    private Label homeTotalTeachers;

    private Connection connect;
    private Statement statement;
    private PreparedStatement preapare;
    private ResultSet result;
    
    
    
    StudentAdmin student = new StudentAdmin();
    
    
    
    public ObservableList<Student> addStudentListData() {
        ObservableList<Student> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM student";
        

        connect = database.connectDb();
        try {
            preapare = connect.prepareStatement(sql);
            result = preapare.executeQuery();            

            while (result.next()) {
                 Student st = new Student();
                    st.setId(result.getString("id"));
                    st.setStname(result.getString("name"));
                    st.setGender(result.getString("gender"));
                    st.setemail(result.getString("email"));
                    st.setphone(result.getString("phone"));
                    st.setfatherName(result.getString("father_name"));
                    st.setmotherName(result.getString("mother_name"));
                    st.setaddress(result.getString("address"));
                
                
                listData.add(st);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return listData;
    }

    private ObservableList<Student> students;
    
     int myIndex;
    int id;
    public void table() {
        connect = database.connectDb();
        
            students = addStudentListData();
            
            table.setItems(students);
            IDColumn.setCellValueFactory(f -> f.getValue().idProperty());
            stnameColumn.setCellValueFactory(f -> f.getValue().stnameProperty());
            genderColumn.setCellValueFactory(f -> f.getValue().genderProperty());
            emailColumn.setCellValueFactory(f -> f.getValue().emailProperty());
            phoneColumn.setCellValueFactory(f -> f.getValue().phoneProperty());
            fatherNameColumn.setCellValueFactory(f -> f.getValue().fatherNameProperty());
            motherNameColumn.setCellValueFactory(f -> f.getValue().motherNameProperty());
            addressColumn.setCellValueFactory(f -> f.getValue().addressProperty());

        table.setRowFactory(
            tv -> {
                TableRow<Student> myRow = new TableRow<>();
                myRow.setOnMouseClicked (
                    event -> {
                        if(event.getClickCount() == 1 && (!myRow.isEmpty())){
                            myIndex = table.getSelectionModel().getSelectedIndex();
                            id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                            
                            studentId.setText(String.valueOf(table.getItems().get(myIndex).getId()));
                            studentName.setText(table.getItems().get(myIndex).getStname());
                            genderS.setText(table.getItems().get(myIndex).getGender());
                            emailS.setText(table.getItems().get(myIndex).getemail());
                            phoneS.setText(table.getItems().get(myIndex).getphone());
                            fatherNameS.setText(table.getItems().get(myIndex).getfatherName());
                            motherNameS.setText(table.getItems().get(myIndex).getmotherName());
                            addressS.setText(table.getItems().get(myIndex).getaddress());
                        }
                    }
                );
                return myRow;
            }
        );
    }
    
    public void homeTotalStudents(){
        String sql = "SELECT COUNT(id) FROM student";
        
        connect = database.connectDb();
        int countStud = 0;
        
        try{
            
            preapare = connect.prepareStatement(sql);
            result = preapare.executeQuery();
            
            while(result.next()){
                countStud = result.getInt("COUNT(id)");
            }
            
            homeTotalStudents.setText(String.valueOf(countStud));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
        public void homeTotalTeachers(){
        String sql = "SELECT COUNT(teacherid) FROM teacher";
        
        connect = database.connectDb();
        int countTeach = 0;
        
        try{
            
            preapare = connect.prepareStatement(sql);
            result = preapare.executeQuery();
            
            while(result.next()){
                countTeach = result.getInt("COUNT(teacherid)");
            }
            
            homeTotalTeachers.setText(String.valueOf(countTeach));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
        
    public void homeTotalCourses(){
        String sql = "SELECT COUNT(courseid) FROM course";
        
        connect = database.connectDb();
        int countCor = 0;
        
        try{
            
            preapare = connect.prepareStatement(sql);
            result = preapare.executeQuery();
            
            while(result.next()){
                countCor = result.getInt("COUNT(courseid)");
            }
            
            homeTotalCourses.setText(String.valueOf(countCor));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
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
                alert = new Alert(Alert.AlertType.ERROR);
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
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student ID: " + studentId.getText() + " was already existent!");
                    alert.showAndWait();
                } else {

                    preapare = connect.prepareStatement(sql);
                    
                    String phoneTest = phoneS.getText();
                    try{
                        if(phoneTest.length() != 10){
                            throw new InvalidPhoneNumberException();
                        }else{
                            preapare.setString(1, studentId.getText());
                            preapare.setString(2, studentName.getText());
                            preapare.setString(3, genderS.getText());
                            preapare.setString(4, emailS.getText());
                            preapare.setString(5, phoneS.getText());
                            preapare.setString(6, fatherNameS.getText());
                            preapare.setString(7, motherNameS.getText());
                            preapare.setString(8, addressS.getText());
                            preapare.executeUpdate();

                            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information Message");
                            alert.setHeaderText(null);
                            alert.setContentText("Successfully Added");
                            alert.showAndWait();
                    
                        }
                    }catch(InvalidPhoneNumberException e){
                        e.printStackTrace();
                    }
                    
                   
                    table();
                    clearStudents();
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void clearStudents() {
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
    public void updateStudent(ActionEvent event) {
        
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
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Student ID: "+ studentId.getText()+"?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                    
                    table();
                    clearStudents();
                }              
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    @FXML
    public void deleteStudent(ActionEvent event) {
        
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
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Student ID: "+ studentId.getText()+"?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();
                    
                    table();
                    clearStudents();
                }              
                
            } 
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void searchStudent() {
        
        FilteredList<Student> filter = new FilteredList<>(students, e-> true);
        searchField.textProperty().addListener((Observable, oldValue, newValue) ->{
            
            filter.setPredicate(predicatestudentData ->{
              
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String searchKey = newValue.toLowerCase();
                
                if(predicatestudentData.getId().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getStname().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getGender().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getemail().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getphone().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getfatherName().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getmotherName().toString().contains(searchKey)){
                    return true;
                }
                else if(predicatestudentData.getaddress().toString().contains(searchKey)){
                    return true;
                }
                else  return false;  
                    
                
            });
            
        });
       
        SortedList<Student> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortList);
        
    }
    
    @FXML
    public void clearStudent(ActionEvent event) {
        clearStudents();
    }
    
    @FXML
    private void switchForm(ActionEvent event) {
        
        if(event.getSource() == homeBtn){
            homePage.setVisible(true);
            studentPage.setVisible(false);
            teacherPage.setVisible(false);
            coursePage.setVisible(false);
        }
        else if(event.getSource() == studentBtn){
            homePage.setVisible(false);
            studentPage.setVisible(true);
            teacherPage.setVisible(false);
            coursePage.setVisible(false);
            table();
            searchStudent();
            
//            addStudentShowListData();
        }
        else if(event.getSource() == teacherBtn){
            homePage.setVisible(false);
            studentPage.setVisible(false);
            teacherPage.setVisible(true);
            coursePage.setVisible(false);
            tableT();
            searchTeacher();
        }
        else if(event.getSource() == courseBtn){
            homePage.setVisible(false);
            studentPage.setVisible(false);
            teacherPage.setVisible(false);
            coursePage.setVisible(true);
            tableC();
            searchCourse();
        }
        
        
    }
    
    public ObservableList<Teacher> addTeacherListData() {
        ObservableList<Teacher> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM teacher";
        

        connect = database.connectDb();
        try {
            preapare = connect.prepareStatement(sql);
            result = preapare.executeQuery();            

            while (result.next()) {
                 Teacher tea = new Teacher();
                    tea.setTeacherID(result.getString("teacherid"));
                    tea.setTeacherName(result.getString("name"));
                    tea.setTGender(result.getString("gender"));
                    tea.setEmail(result.getString("email"));
                    tea.setphoneNo(result.getString("phone"));
                    tea.setTaddress(result.getString("address"));
                    tea.setcourse(result.getString("Course"));
                
                listData.add(tea);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return listData;
    }
    
    private ObservableList<Teacher> teachers;
    
int myIndexT;
int idT;
public void tableT() {
   connect = database.connectDb();
   
      teachers = addTeacherListData();
       
       tTable.setItems(teachers);
       teacherIDColumn.setCellValueFactory(f -> f.getValue().teacherIDProperty());
       teacherNameColumn.setCellValueFactory(f -> f.getValue().setTeacherNameProperty());
       tGenderColumn.setCellValueFactory(f -> f.getValue().tGenderProperty());
       EmailColumn.setCellValueFactory(f -> f.getValue().EmailProperty());
       phoneNoColumn.setCellValueFactory(f -> f.getValue().phoneNoProperty());
       tAddressColumn.setCellValueFactory(f -> f.getValue().tAddressProperty());
       courseColumn.setCellValueFactory(f -> f.getValue().courseProperty());
//       courseColumn.setCellValueFactory(f -> f.getValue().courseProperty());

   tTable.setRowFactory(
       tv -> {
           TableRow<Teacher> myRow = new TableRow<>();
           myRow.setOnMouseClicked (
               event -> {
                   if(event.getClickCount() == 1 && (!myRow.isEmpty())){
                       myIndexT = tTable.getSelectionModel().getSelectedIndex();
                       idT = Integer.parseInt(String.valueOf(tTable.getItems().get(myIndexT).getTeacherID()));
                       
                       teacherID.setText(String.valueOf(tTable.getItems().get(myIndexT).getTeacherID()));
                       teacherName.setText(tTable.getItems().get(myIndexT).getTeacherName());
                       teacherGender.setText(tTable.getItems().get(myIndexT).getTGender());
                       teacherEmail.setText(tTable.getItems().get(myIndexT).getEmail());
                       teacherPhone.setText(tTable.getItems().get(myIndexT).getphoneNo());
                       teacherAddress.setText(tTable.getItems().get(myIndexT).getTaddress());
                       teacherCourse.setText(tTable.getItems().get(myIndexT).getCourse());
                   }
               }
           );
           return myRow;
       }
   );
} 
    Teacher teacher = new Teacher();
     @FXML
    void addTeacher(ActionEvent event) {
         String sql = "INSERT INTO teacher "
                + "(teacherid,name,gender,email,phone,address,Course)"
                + "VALUES(?,?,?,?,?,?,?)";
        connect = database.connectDb();
        try {

            Alert alert;
            if (teacherID.getText().isEmpty() ||
                     teacherName.getText().isEmpty() ||
                     teacherGender.getText().isEmpty() ||
                     teacherEmail.getText().isEmpty() ||
                     teacherPhone.getText().isEmpty() ||
                    teacherAddress.getText().isEmpty() ||
                    teacherCourse.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String check = "SELECT teacherid FROM teacher WHERE teacherid ='"
                        + teacherID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Teacher ID: " + teacherID.getText() + " was already existent!");
                    alert.showAndWait();
                } else {

                    preapare = connect.prepareStatement(sql);
                    
                    String phoneTest = teacherPhone.getText();
                    
                    try{
                        if(phoneTest.length() != 10 ){
                            throw new InvalidPhoneNumberException();                            
                        }else{
                                preapare.setString(1, teacherID.getText());
                                preapare.setString(2, teacherName.getText());
                                preapare.setString(3, teacherGender.getText());
                                preapare.setString(4, teacherEmail.getText());
                                preapare.setString(5, phoneTest);

                                preapare.setString(6, teacherAddress.getText());
                                preapare.setString(7, teacherCourse.getText());
                                preapare.executeUpdate();

                                alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Information Message");
                                alert.setHeaderText(null);
                                alert.setContentText("Successfully Added");
                                alert.showAndWait();
                            
                            
                    
                        }
                    }catch(InvalidPhoneNumberException e){
                        e.printStackTrace();
                    }
                    
                    
//                    addStudentShowListData();
                    tableT();
                    clearTeachers();
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    private void clearTeachers() {
        teacherID.setText(String.valueOf(teacher.getMaxTeacher()));
        teacherName.setText(null);
        teacherGender.setText(null);
        teacherEmail.setText(null);
        teacherPhone.setText(null);
        teacherAddress.setText(null);
        teacherCourse.setText(null);
    }
    @FXML
    public void updateTeacher(ActionEvent event) {
        
        String sql = "UPDATE teacher SET name ='"
                + teacherName.getText() +"', gender = '"
                + teacherGender.getText() + "', email ='"
                + teacherEmail.getText() + "', phone ='"
                + teacherPhone.getText() +"', address ='"
                + teacherAddress.getText()+"', Course='" 
                + teacherCourse.getText()+"'WHERE teacherid ='"
                + teacherID.getText()+"'";
        connect = database.connectDb();
        
        try{
           
            Alert alert;
            if (teacherID.getText().isEmpty() ||
                     teacherName.getText().isEmpty() ||
                     teacherGender.getText().isEmpty() ||
                     teacherEmail.getText().isEmpty() ||
                     teacherPhone.getText().isEmpty() ||
                     teacherAddress.getText().isEmpty() ||
                     teacherCourse.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Teacher ID: "+ teacherID.getText()+"?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                    
                    tableT();
                    clearTeachers();
                }              
                
            }   
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
     @FXML
    public void deleteTeacher(ActionEvent event) {
    
    
        String sql = "DELETE FROM teacher WHERE teacherid = '"
                + teacherID.getText() + "'";
        connect = database.connectDb();
        
        try{
           
            Alert alert;
            if (teacherID.getText().isEmpty() ||
                     teacherName.getText().isEmpty() ||
                     teacherGender.getText().isEmpty() ||
                     teacherEmail.getText().isEmpty() ||
                     teacherPhone.getText().isEmpty() ||
                     teacherAddress.getText().isEmpty() ||
                     teacherCourse.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Teacher ID: "+ teacherID.getText()+"?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully DELETED!");
                    alert.showAndWait();
                    
                    tableT();
                    clearTeachers();
                }              
                
            }   
        }catch(Exception e){
            e.printStackTrace();
        }
}
    
    @FXML
    public void searchTeacher() {
        
    FilteredList<Teacher> filter = new FilteredList<>(teachers, e-> true);
    searchTeachers.textProperty().addListener((Observable, oldValue, newValue) ->{
        
        filter.setPredicate(predicateteacherData ->{
          
            if(newValue == null || newValue.isEmpty()){
                return true;
            }
            
            String searchKey = newValue.toLowerCase();
            
            if(predicateteacherData.getTeacherID().toString().contains(searchKey)){
                return true;
            }
            else if(predicateteacherData.getTeacherName().toString().contains(searchKey)){
                return true;
            }
            else if(predicateteacherData.getTGender().toString().contains(searchKey)){
                return true;
            }
            else if(predicateteacherData.getEmail().toString().contains(searchKey)){
                return true;
            }
            else if(predicateteacherData.getphoneNo().toString().contains(searchKey)){
                return true;
            }
            else if(predicateteacherData.getTaddress().toString().contains(searchKey)){
                return true;
            }
            else if(predicateteacherData.getCourse().toString().contains(searchKey)){
                return true;
            }
            else  return false;  
                
            
        });
        
    });
   
    SortedList<Teacher> sortList = new SortedList<>(filter);
    sortList.comparatorProperty().bind(tTable.comparatorProperty());
    tTable.setItems(sortList);
    
}
    
    @FXML
    public void clearTeacher(ActionEvent event) {
        clearTeachers();
    }
    
    public ObservableList<Course> addCourseListData() {
        ObservableList<Course> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM course";
        connect = database.connectDb();
        try {
            preapare = connect.prepareStatement(sql);
            result = preapare.executeQuery();            

            while (result.next()) {
                 Course cr = new Course();
                    cr.setCourseID(result.getString("courseid"));
                    cr.setCourseName(result.getString("coursename"));
                    cr.setCreditHour(result.getString("credit_hour"));
                
                listData.add(cr);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return listData;
    }
    
    private ObservableList<Course> courses;
    
     int myIndexC;
    int idC;
    public void tableC() {
        connect = database.connectDb();

            courses = addCourseListData();           
            tableC.setItems(courses);
            courseIDColumn.setCellValueFactory(f -> f.getValue().courseIDProperty());
            courseNameColumn.setCellValueFactory(f -> f.getValue().CourseNameProperty());
            creditHourColumn.setCellValueFactory(f -> f.getValue().creditHourProperty());
           
        tableC.setRowFactory(
            tv -> {
                TableRow<Course> myRow = new TableRow<>();
                myRow.setOnMouseClicked (
                    event -> {
                        if(event.getClickCount() == 1 && (!myRow.isEmpty())){
                            myIndexC = tableC.getSelectionModel().getSelectedIndex();
                            idC = Integer.parseInt(String.valueOf(tableC.getItems().get(myIndexC).getCourseID()));  
                            courseID.setText(String.valueOf(tableC.getItems().get(myIndex).getCourseID()));
                            courseName.setText(tableC.getItems().get(myIndex).getCourseName());
                            creditHour.setText(tableC.getItems().get(myIndex).getCreditHour());
                        }
                    }
                );
                return myRow;
            }
        );
    }
    
    @FXML
    public void addCourse(ActionEvent event) {
        String sql = "INSERT INTO course "
                + "(courseid,coursename,credit_hour)"
                + "VALUES(?,?,?)";
        connect = database.connectDb();
        try {

            Alert alert;
            if (courseID.getText().isEmpty()||
                     courseName.getText().isEmpty()||
                     creditHour.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String check = "SELECT courseid FROM course WHERE courseid ='"
                        + courseID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Course ID: " + courseID.getText() + " was already existent!");
                    alert.showAndWait();
                } else {

                    preapare = connect.prepareStatement(sql);
                    preapare.setString(1, courseID.getText());
                    preapare.setString(2, courseName.getText());
                    preapare.setString(3, creditHour.getText());
                    preapare.executeUpdate();
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added");
                    alert.showAndWait();
                    
                    
                    tableC();
                    clearCourses();
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void updateCourse(ActionEvent event) {
        
        String sql = "UPDATE course SET coursename ='"
                + courseName.getText() +"', credit_hour = '"
                + creditHour.getText() + "'WHERE courseid ='"
                + courseID.getText()+"'";

        connect = database.connectDb();
        
        try{
           
            Alert alert;
            if (courseID.getText().isEmpty()||
                     courseName.getText().isEmpty()||
                     creditHour.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Course ID: "+ courseID.getText()+"?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                    
                    tableC();
                    clearCourses();
                }              
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void deleteCourse(ActionEvent event) {
        
        String sql = "DELETE FROM course WHERE courseid = '"
                + courseID.getText()+"'";
        
        connect = database.connectDb();
        
        try{
            
           Alert alert;
            if (courseID.getText().isEmpty()||
                     courseName.getText().isEmpty()||
                     creditHour.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Course ID: "+ courseID.getText()+"?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();
                    
                    tableC();
                    clearCourses();
                }              
                
            } 
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void clearCourse(ActionEvent event) {
        clearCourses();
    }
    Course crs = new Course();
    private void clearCourses() {
       courseID.setText(String.valueOf(crs.getMaxCourse()));
       courseName.setText(null);
       creditHour.setText(null);

}
    @FXML
    public void searchCourse() {
        
    FilteredList<Course> filter = new FilteredList<>(courses, e-> true);
    searchCourses.textProperty().addListener((Observable, oldValue, newValue) ->{
        
        filter.setPredicate(predicatecourseData ->{
          
            if(newValue == null || newValue.isEmpty()){
                return true;
            }
            
            String searchKey = newValue.toLowerCase();
            
            if(predicatecourseData.getCourseID().toString().contains(searchKey)){
                return true;
            }
            else if(predicatecourseData.getCourseName().toString().contains(searchKey)){
                return true;
            }
            else if(predicatecourseData.getCreditHour().toString().contains(searchKey)){
                return true;
            }
            else  return false;   
        });
        
    });
   
    SortedList<Course> sortList = new SortedList<>(filter);
    sortList.comparatorProperty().bind(tableC.comparatorProperty());
    tableC.setItems(sortList);
    
}    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        addStudentShowListData();
        table();
        tableT();
        tableC();
        homeTotalCourses();
        homeTotalStudents();
        homeTotalTeachers();
        
        studentId.setText(String.valueOf(student.getMax()));
        teacherID.setText(String.valueOf(teacher.getMaxTeacher()));
        courseID.setText(String.valueOf(crs.getMaxCourse()));
    }    

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }

    

    

}

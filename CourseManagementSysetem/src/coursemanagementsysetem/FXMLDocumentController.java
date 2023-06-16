/////*
//// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//// * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
//// */
package coursemanagementsysetem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


/**
 *
 * @author bageg
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private Button close;

    @FXML
    private TextField username;

    @FXML
    private Button login;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField password;
    
    private Connection connect;
    private PreparedStatement preapare;
    private ResultSet result;
    
    public void Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/course_management", "root", "@Bcd");
        }catch(ClassNotFoundException ex){
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    PreparedStatement ps;
    @FXML
    void loginAdmin(ActionEvent event) {
        
        String sql = "Select * from admin WHERE username = ? and password = ?";
        
        connect = database.connectDb();
        
        try {
            preapare = connect.prepareStatement(sql);
            preapare.setString(1, username.getText());
            preapare.setString(2, password.getText());
            
            result = preapare.executeQuery();
            Alert alert;
            
            if(username.getText().isEmpty() || password.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
            }else{
                if(result.next()){
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfully Login");
                    
                    login.getScene().getWindow().hide();
                    try { 
                        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void close() {
        System.exit(0);
    }
//    public void close(){
//        System.exit(0);
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database.connectDb();
    }    
    
}

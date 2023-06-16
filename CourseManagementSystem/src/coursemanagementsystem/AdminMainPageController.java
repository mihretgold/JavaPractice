/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coursemanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bageg
 */
public class AdminMainPageController implements Initializable {

     @FXML
    private Button coursebutton;

    @FXML
    private Button homebutton;

    @FXML
    private FontAwesomeIcon logOutBtn;

    @FXML
    private Button studentbutton;

    @FXML
    private Button teacherbutton;

    @FXML
    private Label totaladmin;

    @FXML
    private Label totalcourses;

    @FXML
    private Label totalstudents;

    @FXML
    private Label totalteachers;
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private BorderPane bordPane;
    @FXML
    void coursepage(ActionEvent event) {

    }

    @FXML
    void homepage(ActionEvent event) {
         
    }

    @FXML
    void logOut(MouseEvent event) {

    }

    @FXML
    void studentpage(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("studentPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            
            
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    @FXML
    void teacherpage(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

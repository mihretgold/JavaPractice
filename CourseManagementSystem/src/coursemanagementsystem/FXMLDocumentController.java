/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package coursemanagementsystem;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author bageg
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button adminPageBtn;

    @FXML
    private Button studentPageBtn;

    @FXML
    private Button teacherPageBtn;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    void AdminPage(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    void studentPage(ActionEvent event) {

    }

    @FXML
    void teacherPage(ActionEvent event) {

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coursemanagementsysetem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author bageg
 */
public class DashboardController implements Initializable {

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
    private TextField searchTeacher1;
    @FXML
    private TextField teacherID1;
    @FXML
    private TextField teacherName1;
    @FXML
    private Button addBtn11;
    @FXML
    private Button updateBtn11;
    @FXML
    private Button deleteBtn11;
    @FXML
    private Button clearBtn11;
    @FXML
    private AnchorPane studentPage1;
    @FXML
    private TextField searchTeacher;
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
    private ComboBox<?> teacherGender;
    @FXML
    private Button addBtn1;
    @FXML
    private Button updateBtn1;
    @FXML
    private Button deleteBtn1;
    @FXML
    private Button clearBtn1;
    @FXML
    private ChoiceBox<?> course;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void close(ActionEvent event) {
    }
    
}

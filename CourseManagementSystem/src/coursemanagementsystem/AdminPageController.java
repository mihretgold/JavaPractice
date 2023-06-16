/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coursemanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author bageg
 */
public class AdminPageController implements Initializable {

      @FXML
    private Button close;

    @FXML
    private Button login;

    @FXML
    private TextField password;

    @FXML
    private TextField username;
    private Button teacherPageBtn;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    void login(ActionEvent event) {
        String userName = username.getText();
        String pass = password.getText();
        
        if(userName.equals("") && pass.equals("")){
            JOptionPane.showMessageDialog(null, "UserName or Password Blank");
        }else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management", "root","@Bcd");
                pst = con.prepareStatement("select * from admin where username = ? and password = ?");
                
                pst.setString(1,userName);
                pst.setString(2, pass);
                try{
                rs = pst.executeQuery();
                }catch(Exception e){
                    System.out.println(e);
                }
                if(rs.next()){
                    try {
                        root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
                }else{
                    JOptionPane.showMessageDialog(null, "Login Failed");
                    username.setText("");
                    password.setText("");
                    username.requestFocus();
                }
                
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
                Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
                
            } catch (SQLException ex) {
                Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
            catch(Exception e){
                System.out.println(e);
            }
            
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

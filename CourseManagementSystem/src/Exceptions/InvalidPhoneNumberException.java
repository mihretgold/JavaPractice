/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

import javafx.scene.control.Alert;

/**
 *
 * @author bageg
 */
public class InvalidPhoneNumberException extends Exception{
    public InvalidPhoneNumberException(){
        super("Please enter a valid phone number");
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Please enter a valid phone number");
        alert.showAndWait();
    }
}

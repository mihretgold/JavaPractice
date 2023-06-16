package rmi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bageg
 */
import java.rmi.Naming;

public class RemoteClient {
    public static void main(String[] args){
        try{
            RemoteInterface remoteObject = (RemoteInterface) Naming.lookup("rmi://localhost/Remote");
            String result = remoteObject.sayHello("Mihret");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

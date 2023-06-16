/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

/**
 *
 * @author bageg
 */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class RemoteInterfaceImpl extends UnicastRemoteObject implements RemoteInterface{
    public RemoteInterfaceImpl() throws RemoteException{
        super();
    }
    public String sayHello(String name) throws RemoteException{
        return "Hello " + name;
    }
    
}

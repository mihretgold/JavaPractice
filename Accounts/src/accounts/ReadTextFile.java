/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accounts;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author bageg
 */
public class ReadTextFile {
    private Scanner input;
    
    public void openFile(){
        try{
            input = new Scanner(new File("client.txt"));
        }catch(FileNotFoundException fileNotFoundException){
            System.out.println("File not found");
            System.exit(1);
        }
        
    }
    public void readRecords(){
         Accounts record = new Accounts();
            System.out.printf("%s %s", "Account, FirstName, LastName, Balance", ":");
        try{       
            while(input.hasNext()){
               record.setAccount(input.nextInt());
               record.setFirstName(input.nextLine());
               record.setLastName(input.nextLine());
               record.setBalance(input.nextDouble());

               System.out.printf("%d %s %s %.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());

            } 
        }catch(IllegalStateException illegal){
            System.out.println("Illegal State");
            System.exit(1);
        }catch(NoSuchElementException nosuch){
            System.out.println("Illegal State");
            input.close();
            System.exit(1);
        }
        
        
    }
    public void closed(){
        if(input != null){
            input.close();
        }
    }
    public static void main(String[] args){
        ReadTextFile application = new ReadTextFile();
        
        application.openFile();
        application.readRecords();
        application.closed();
    }
}

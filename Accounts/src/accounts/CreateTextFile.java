/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accounts;
//For exception Handling
import java.io.FileNotFoundException;
import java.lang.SecurityException;
//Class to use Formatter
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author bageg
 */
public class CreateTextFile {
    private Formatter output;
    public void openFile(){
        try{
            output = new Formatter("client.txt");//open file
        }catch(SecurityException securityException){
            System.out.println("Access denied: ");
            System.exit(1);
        }catch(FileNotFoundException fileNotException){
            System.out.println("Error opening and creating the file.");
            System.exit(1);
        }
    }
    
    public void addRecords(){
        Accounts record = new Accounts();
        Scanner input = new Scanner(System.in);
        System.out.printf("%s\n%s\n%s\n%s\n\n", "To terminate input, type the end-of-file indicator ", "when you are prompted to enter input.", "On UNIX/linux/mac typr ctrl d then press Enter", "On Windows type ctrl z then press Enter");
        System.out.printf("%s\n%s", "Enter account number (> 0) firstname, lastname, and balance.", "?");
        
        while(input.hasNext()){//loop until file ends
           try{
               record.setAccount(input.nextInt());
               record.setFirstName(input.nextLine());
               record.setLastName(input.nextLine());
               record.setBalance(input.nextDouble());
               
               if(record.getAccount() > 0){
                   //write new record
                   output.format("%d %s %s %.2f\n", record.getAccount()
                   , record.getFirstName(), record.getLastName(), record.getBalance());
                   
               }
               else{
                 System.out.println( "Account number must be greater than 0." );
                 
               }
           }catch(FormatterClosedException formatterClosedException){
               System.out.println("Error writing to File.");
               return;
           }catch(NoSuchElementException elemetException){
               System.out.println("Invalid input. Please try again.");
               input.nextLine();//discard input so user can try again
           } 
           System.out.printf("%s %s\n%s", "Enter account number (>0),", "firstname, lastname, balance", "?");
           
        }
            
    }
    public void closedFile(){
        if( output != null){
            output.close();
        }
    }
    public static void main(String[] args){
       CreateTextFile application =  new CreateTextFile();
       
       application.openFile();
       application.addRecords();
       application.closedFile();
    }
}

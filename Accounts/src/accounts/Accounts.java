/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package accounts;

/**
 *
 * @author bageg
 */
public class Accounts {

    /**
     * @param args the command line arguments
     */
    private int account;
    private String firstName;
    private String lastName;
    private double balance;
    
    public Accounts(){
        this(0,"","",0.0);
    }
    public Accounts(int acct, String first, String last, double bal){
        setAccount(acct);
        setFirstName(first);
        setLastName(last);
        setBalance(bal);
    }
    public void setAccount(int acct){
        account = acct;
    }
    public int getAccount(){
        return account;
    }
    public void setFirstName(String first){
        firstName = first;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String last){
        lastName = last;
    }
    public String getLastName(){
        return lastName;
    }
    public void setBalance(double bal){
        balance = bal;
    }
    public Double getBalance(){
        return balance;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;

/**
 *
 * @author bageg
 */
public abstract  class Person {
    private String name;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    
//    abstract String getName();
//    abstract String setName(String name);
//    abstract String getGender();
//    abstract String setGender(String name);
//    abstract String getPhoneNumber();
//    abstract String setPhoneNumber(String name);
//    abstract String getEmail();
//    abstract String setEmail(String name);
//    abstract String getAddress();
//    abstract String setAddress(String name);
    public boolean isPhone(String operand){
    if(!operand.equals("")){
        if(((operand.matches("[a-zA-Z]*")))){ //Exception
            return true;
        }
        else return false;
    }
    return false;
}
    public boolean isEmail(String operand){
    if(!operand.equals("")){
        if(((operand.matches("^(.+)@(.+)$*")))){ //Exception
            return true;
        }
        else return false;
    }
    return false;
}
}

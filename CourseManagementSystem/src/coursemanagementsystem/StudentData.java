/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;

/**
 *
 * @author bageg
 */
public class StudentData {
    private Integer studId;
    private String studName;
    private String studGender;
    private String studEmail;
    private String studPhone;
    private String studFatherName;
    private String studMotherName;
    private String studAddress;
    
    public StudentData(Integer studId, String studName, String studGender, String studEmail, String studPhone, String studFatherName, String studMotherName, String studAddress){
        this.studId = studId;
        this.studName = studName;
        this.studGender = studGender;
        this.studEmail = studEmail;
        this.studPhone = studPhone;
        this.studFatherName = studFatherName;
        this.studMotherName = studMotherName;
        this.studAddress = studAddress;
    }
    
    public Integer getStudentId(){
        return studId;
    }
    public String getStudentName(){
        return studName;
    }
    public String getStudentGender(){
        return studGender;
    }
    public String getStudentEmail(){
        return studEmail;
    }
    public String getStudentPhone(){
        return studPhone;
    }
    public String getStudentFatherName(){
        return studFatherName;
    }
    public String getStudentMotherName(){
        return studMotherName;
    }
    public String getStudentAddress(){
        return studAddress;
    }
    
//    public String getAllData(){
//        return "Id "+getStudentId()+"Name "+getStudentName();
//    }
}

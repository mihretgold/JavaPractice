/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package files;

//File class used to obtain file and directory information
import java.io.File;
import java.util.Scanner;

public class Files{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file or directory name: ");
        analyzePath(input.nextLine());
    }
    public static void analyzePath(String path) {
        File name = new File( path);
        if(name.exists()){
            System.out.printf("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
            name.getName(), " exists",
            (name.isFile() ? "is a file" : "is not a file"), (name.isDirectory() ? "is a directory" : "is not directory"), 
            (name.isAbsolute() ? "is absoulute path" : "is not absolute path"), "Last modified: ", name.lastModified(), 
            "Length: ",name.length(), "Path: ", name.getPath(), "Absolute path: ", name.getAbsoluteFile(), 
            "Parent: ", name.getParent() );

        }
        
        if(name.isDirectory()){
            String[] directory = name.list();
            System.out.println("\n\nDirectory contents:\n" );

            for(String directoryName : directory)
                System.out.println(directoryName);
            
        }
        else{
            System.out.printf("%s %s", path, "does not exist");
        }
    }

}


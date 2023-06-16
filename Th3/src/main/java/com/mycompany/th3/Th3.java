/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.th3;

/**
 *
 * @author bageg
 */
//Thread and Socket
public class Th3 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask("Task 1"));
        Thread t2 = new Thread(new MyTask("Task 2"));
        t1.start();
        t2.start();
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.t2;

/**
 *
 * @author bageg
 */
public class T2 {

    public static void main(String[] args) {
        Multi2 M2 = new Multi2();
        Thread Th2 = new Thread(M2);
        Th2.start();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.th3;

/**
 *
 * @author bageg
 */
public class MyTask implements Runnable{
    private String name;
    public MyTask(String name){
        this.name = name;
    }
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println(name + "   " + i);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

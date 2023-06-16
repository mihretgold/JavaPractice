/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author bageg
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentManagementSystem {

    public static void main(String[] args) {
        
        // Create a new thread pool with a fixed number of threads
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        
        // Create a new task to perform in the background
        Runnable task = new Runnable() {
            @Override
            public void run() {
                // Perform some long-running operation here
                // For example, load data from a database or perform calculations
                System.out.println("Background task complete");
            }
        };
        
        // Submit the task to the thread pool
        threadPool.submit(task);
        
        // Do some other work while the task is running in the background
        System.out.println("Main thread continuing to run");
        
        // Shut down the thread pool when we're done with it
        threadPool.shutdown();
    }
}
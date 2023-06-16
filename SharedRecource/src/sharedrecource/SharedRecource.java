/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sharedrecource;

import java.util.Scanner;

/**
 *
 * @author bageg
 */
public class SharedRecource {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of threads to use: ");
        int numThreads = scanner.nextInt();
        System.out.print("Enter the number of operations to perform: ");
        int numOps = scanner.nextInt();
        Counter counter = new Counter();
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            if (i % 2 == 0) {
                threads[i] = new Thread(new IncrementTask(counter, numOps));
            } else {
                threads[i] = new Thread(new DecrementTask(counter, numOps));
            }
            threads[i].start();
        }
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
        System.out.println("Final value: " + counter.intgetValue());
    }

    private static class Counter {
        private int value;

        public synchronized void increment() {
            value++;
        }

        public synchronized void decrement() {
            value--;
        }

        public synchronized int intgetValue() {
            return value;
        }
    }

    private static class IncrementTask implements Runnable {
        private final Counter counter;
        private final int numOps;

        public IncrementTask(Counter counter, int numOps) {
            this.counter = counter;
            this.numOps = numOps;
        }

        @Override
        public void run() {
            for (int i = 0; i < numOps; i++) {
                counter.increment();
            }
        }
    }

    private static class DecrementTask implements Runnable {
        private final Counter counter;
        private final int numOps;

        public DecrementTask(Counter counter, int numOps) {
            this.counter = counter;
            this.numOps = numOps;
        }

        @Override
        public void run() {
            for (int i = 0; i < numOps; i++) {
                counter.decrement();
            }
        }
    }
    
}

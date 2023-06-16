/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package factorial;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to calculate the factorial of: ");
        int number = scanner.nextInt();
        System.out.print("Enter the number of threads to use: ");
        int numThreads = scanner.nextInt();
        BigInteger[] results = new BigInteger[numThreads];
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            final int index = i;
            int start = index * (number / numThreads) + 1;
            int end = (index == numThreads - 1) ? number : (index + 1) * (number / numThreads);
            FactorialTask task = new FactorialTask(start, end);
            results[index] = BigInteger.valueOf(1);
            threads[index] = new Thread(() -> results[index] = task.call());
            threads[index].start();
        }
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
                result = result.multiply(results[i]);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
        System.out.println("Factorial of " + number + " is " + result);
    }

    private static class FactorialTask implements Runnable {

        private final int start;
        private final int end;
        private BigInteger result;

        public FactorialTask(int start, int end) {
            this.start = start;
            this.end = end;
            this.result = BigInteger.ONE;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
        }

        public BigInteger call() {
            run();
            return result;
        }
    }
}

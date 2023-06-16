/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maxfinder;

import java.util.Random;
import java.util.Scanner;

public class MaxFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the sequence: ");
        int length = scanner.nextInt();
        System.out.print("Enter the number of threads to use: ");
        int numThreads = scanner.nextInt();

        int[] sequence = generateSequence(length);
        Thread[] threads = new Thread[numThreads];
        MaxFinderTask[] tasks = new MaxFinderTask[numThreads];
        int chunkSize = sequence.length / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? sequence.length - 1 : (i + 1) * chunkSize - 1;
            tasks[i] = new MaxFinderTask(sequence, start, end);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
                max = Math.max(max, tasks[i].getMax());
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
        System.out.println("Maximum value in sequence: " + max);
    }

    private static int[] generateSequence(int length) {
        int[] sequence = new int[length];
        Random random = new Random();
       for (int i = 0; i < length; i++) {
            sequence[i] = random.nextInt(1000000);
        }
        return sequence;
    }
}

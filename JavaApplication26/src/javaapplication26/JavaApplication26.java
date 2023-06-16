/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication26;

/**
 *
 * @author bageg
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JavaApplication26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Load a text file
        String text = loadTextFile("document.txt");
        System.out.println("1" + text);

        // Create a thread pool with four threads
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        // Split the text into four segments
        String[] segments = splitText(text, 4);
        System.out.println("2" + segments);

        // Create a task to count the words in each segment
        WordCountTask[] tasks = new WordCountTask[4];
        for (int i = 0; i < 4; i++) {
            tasks[i] = new WordCountTask(segments[i]);
        }
        System.out.println("3" + tasks);

        // Submit the tasks to the thread pool
        for (int i = 0; i < 4; i++) {
            threadPool.submit(tasks[i]);
        }

        // Wait for the tasks to complete
        try {
            threadPool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            System.out.println("Error waiting for task completion: " + e.getMessage());
        }

        // Combine the word counts
        AtomicInteger totalCount = new AtomicInteger(0);
        for (int i = 0; i < 4; i++) {
            totalCount.addAndGet(tasks[i].getCount());
        }

        // Display the total word count
        System.out.println("Total word count: " + totalCount.get());

        // Shut down the thread pool
        threadPool.shutdown();

    }

    private static String loadTextFile(String filename) {
        // Load a text file into a string
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filename));
            System.out.println("Loaded");
            return new String(encoded, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Error loading text file: " + e.getMessage());
            return "";
        }
    }

    private static String[] splitText(String text, int numSegments) {
        // Split a text string into multiple segments
        String[] segments = new String[numSegments];
        int segmentLength = (int) Math.ceil((double) text.length() / numSegments);
        for (int i = 0; i < numSegments; i++) {
            int startIndex = i * segmentLength;
            int endIndex = Math.min((i + 1) * segmentLength, text.length());
            segments[i] = text.substring(startIndex, endIndex);
        }
        System.out.println("Split");
        return segments;
    }

    private static class WordCountTask implements Runnable {

        private final String segment;
        private int count;

        public WordCountTask(String segment) {
            this.segment = segment;
        }

        @Override
        public void run() {
            // Count the number of words in the segment
            String[] words = segment.split("\\s+");
            count = words.length;
        }

        public int getCount() {
            return count;
        }
    }

}

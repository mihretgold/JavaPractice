/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restaurant;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {

    public static void main(String[] args) {
        Queue<String> counter = new LinkedList<>();
        ChefTask chefTask = new ChefTask(counter);
        Thread chefThread = new Thread(chefTask);
        Thread waiterThread1 = new Thread(new WaiterTask("Waiter 1", counter));
        Thread waiterThread2 = new Thread(new WaiterTask("Waiter 2", counter));
        chefThread.start();
        waiterThread1.start();
        waiterThread2.start();
        try {
            Thread.sleep(5000); // wait for 5 seconds
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        chefTask.stop(); // interrupt the ChefTask thread
        try {
            chefThread.join();
            waiterThread1.join();
            waiterThread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }

    private static class ChefTask implements Runnable {
    private final Queue<String> counter;
    private volatile boolean running;

    public ChefTask(Queue<String> counter) {
        this.counter = counter;
        this.running = true;
    }

    @Override
    public void run() {
        while (running) {
            String dish = prepareDish();
            synchronized (counter) {
                counter.offer(dish);
                System.out.println("Chef prepared " + dish + ", now on the counter");
                counter.notifyAll();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Chef thread interrupted");
                running = false;
            }
        }
    }

    private String prepareDish() {
        // code for preparing a dish
        return "Dish " + (counter.size() + 1);
    }

    public void stop() {
        running = false;
    }
}

    private static class WaiterTask implements Runnable {

        private final String name;
        private final Queue<String> counter;

        public WaiterTask(String name, Queue<String> counter) {
            this.name = name;
            this.counter = counter;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (counter) {
                    while (counter.isEmpty()) {
                        try {
                            counter.wait();
                        } catch (InterruptedException e) {
                            System.out.println(name + " thread interrupted");
                        }
                    }
                    String dish = counter.poll();
                    System.out.println(name + " took " + dish + " from the counter");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(name + " thread interrupted");
                }
            }
        }
    }
}

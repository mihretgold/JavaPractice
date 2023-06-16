/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package NumberPrinterThread;

/**
 *
 * @author bageg
 */
public class NumberPrinter {

  public static void main(String[] args) {
      Thread thread1 = new Thread(new NumberPrinterTask(1, 50));
      Thread thread2 = new Thread(new NumberPrinterTask(51, 100));
      thread1.start();
      thread2.start();
      try {
          thread1.join();
          thread2.join();
      } catch (InterruptedException e) {
          System.out.println("Main thread interrupted");
      }
  }

  private static class NumberPrinterTask implements Runnable {
      private final int start;
      private final int end;

      public NumberPrinterTask(int start, int end) {
          this.start = start;
          this.end = end;
      }

      @Override
      public void run() {
          for (int i = start; i <= end; i++) {
              System.out.println(i);
          }
      }
  }
}

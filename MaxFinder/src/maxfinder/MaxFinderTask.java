/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maxfinder;

/**
 *
 * @author bageg
 */
public class MaxFinderTask implements Runnable {

    private int[] sequence;
    private int start;
    private int end;
    private int max;

    public MaxFinderTask(int[] sequence, int start, int end) {
        this.sequence = sequence;
        this.start = start;
        this.end = end;
        this.max = Integer.MIN_VALUE;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            max = Math.max(max, sequence[i]);
        }
    }

    public int getMax() {
        return max;
    }
}
package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // e.g., java BenchmarkRunner 1000
        int[] arr = new Random().ints(n, 0, 10000).toArray();
        PerformanceTracker tracker = new PerformanceTracker();
        long start = System.nanoTime(); // Manual timing for now
        InsertionSort.sort(arr, tracker);
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1e6 + " ms");
        System.out.println("Comparisons: " + tracker.getComparisons());
        System.out.println("Swaps: " + tracker.getSwaps());
        System.out.println("Array Accesses: " + tracker.getArrayAccesses());
        tracker.exportToCSV("benchmark.csv"); // Export to CSV
    }
}
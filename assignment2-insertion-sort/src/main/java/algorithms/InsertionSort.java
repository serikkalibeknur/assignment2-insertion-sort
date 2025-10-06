package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {
    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null) throw new IllegalArgumentException("Array is null");
        if (arr.length <= 1) return;

        tracker.startTiming(); // Start timing the sort
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            tracker.incrementArrayAccesses(); // Access to arr[i]
            int j = i - 1;
            while (j >= 0) {
                tracker.incrementComparisons(); // Comparison
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    tracker.incrementSwaps(); // Swap
                    tracker.incrementArrayAccesses(); // Two accesses
                    j--;
                } else {
                    break; // Early exit for nearly-sorted optimization
                }
            }
            arr[j + 1] = key;
            tracker.incrementArrayAccesses(); // Access to arr[j+1]
        }
        tracker.stopTiming(); // Stop timing (handled in export)
    }

    // Optional: Overload for convenience if needed
    public static void sort(int[] arr) {
        PerformanceTracker tracker = new PerformanceTracker();
        sort(arr, tracker);
        tracker.exportToCSV("benchmark.csv"); // Default export
    }
}
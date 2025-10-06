package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {
    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null) throw new IllegalArgumentException("Array is null");
        if (arr.length <= 1) return;

        tracker.startTiming();
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            tracker.incrementArrayAccesses(); // Access to arr[i]
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                tracker.incrementComparisons();
                arr[j + 1] = arr[j]; // Shift larger element right
                tracker.incrementSwaps();
                tracker.incrementArrayAccesses(); // Access to arr[j+1]
                j--;
            }
            if (j + 1 != i) { // Insert key only if shifted
                arr[j + 1] = key;
                tracker.incrementArrayAccesses(); // Access to arr[j+1]
            }
        }
        tracker.stopTiming();
    }

    public static void sort(int[] arr) {
        PerformanceTracker tracker = new PerformanceTracker();
        sort(arr, tracker);
        tracker.exportToCSV("benchmark.csv");
    }
}
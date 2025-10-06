package metrics;

import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0; // Optional: Track array accesses
    private long startTime = 0;     // Optional: Track execution time

    // Increment counters
    public void incrementComparisons() { comparisons++; }
    public void incrementSwaps() { swaps++; }
    public void incrementArrayAccesses() { arrayAccesses++; }
    public void startTiming() { startTime = System.nanoTime(); }
    public void stopTiming() { /* No action here, handled in export */ }

    // Getters
    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }
    public long getExecutionTime() {
        return (startTime > 0) ? (System.nanoTime() - startTime) / 1_000_000 : 0; // in milliseconds
    }

    // Export metrics to CSV
    public void exportToCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) { // 'true' appends to file
            writer.append(String.format("%d,%d,%d,%d%n",
                    getComparisons(), getSwaps(), getArrayAccesses(), getExecutionTime()));
            if (startTime > 0) {
                startTime = 0; // Reset timing after export
            }
        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }
    }

    // Reset counters (optional, for reuse)
    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        startTime = 0;
    }
}
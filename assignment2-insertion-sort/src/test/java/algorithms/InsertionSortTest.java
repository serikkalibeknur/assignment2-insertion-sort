package algorithms;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {
    @Test
    public void testEmptyArray() {
        int[] arr = {};
        int[] expected = arr.clone();
        InsertionSort.sort(arr);
        assertArrayEquals(expected, arr);
        Arrays.sort(expected); // Cross-validation
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {5};
        int[] expected = arr.clone();
        InsertionSort.sort(arr);
        assertArrayEquals(expected, arr);
        Arrays.sort(expected);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testDuplicates() {
        int[] arr = {3, 1, 3, 2};
        int[] expected = arr.clone();
        Arrays.sort(expected);
        InsertionSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSorted() {
        int[] arr = {1, 2, 3, 4};
        int[] expected = arr.clone();
        InsertionSort.sort(arr);
        assertArrayEquals(expected, arr);
        Arrays.sort(expected);
        assertArrayEquals(expected, arr);
    }


    @Test
    public void testReverseSorted() {
        int[] arr = {4, 3, 2, 1};
        int[] expected = {4, 3, 2, 1};
        Arrays.sort(expected); // Expected should be sorted ascending
        InsertionSort.sort(arr); // Sort using your custom method
        assertArrayEquals(expected, arr); // Compare results
    }

}
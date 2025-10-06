package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {
    @Test
    public void testEmptyArray() {
        int[] arr = {};
        InsertionSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {5};
        InsertionSort.sort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    public void testDuplicates() {
        int[] arr = {3, 1, 3, 2};
        InsertionSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 3}, arr);
    }

    @Test
    public void testSorted() {
        int[] arr = {1, 2, 3, 4};
        InsertionSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr);
    }

    @Test
    public void testReverseSorted() {
        int[] arr = {4, 3, 2, 1};
        InsertionSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr);
    }
}
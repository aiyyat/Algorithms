package com.aiyyatti.algorithms.gfg.arrays;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * https://www.geeksforgeeks.org/check-if-an-array-is-sorted-and-rotated/
 */
public class CheckIfAnArrayIsSortedAndRotated {
    @Test
    public void testSimple() {
        TestCase.assertFalse(checkSortedAndRotated(new int[]{3, 4, 5, 2, 1}));
    }

    @Test
    public void testSimple2() {
        TestCase.assertTrue(checkSortedAndRotated(new int[]{3, 4, 5, 1, 2}));
    }

    public boolean checkSortedAndRotated(int[] a) {
        int N = a.length;
        boolean isIncreasing = false;
        for (int i = 1; i < N; i++) {
            if (a[i - 1] < a[i]) {
                isIncreasing = true;
                continue;
            }
            if (isIncreasing && a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }
}

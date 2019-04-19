package com.aiyyatti.algorithms.gfg.misc;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Largest Sum Contiguous Subarray
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 * <p>
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class LargestSumContigousSubArray {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void testSimple() {
        TestCase.assertEquals(7, doLargestSumContigousArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }

    private int doLargestSumContigousArray(int[] a) {
        int maxSumTillNow = 0;
        int sumTillNow = 0;
        for (int i = 0; i < a.length; i++) {
            sumTillNow += a[i];
            if (sumTillNow < 0) sumTillNow = 0;
            maxSumTillNow = Math.max(maxSumTillNow, sumTillNow);
        }
        return maxSumTillNow;
    }
}

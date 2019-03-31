package com.aiyyatti.algorithms.leetcode.problems;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubArray {
    @Test
    public void testSimple() {
        TestCase.assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }

    public int maxSubArray(int[] a) {
        int N = a.length;
        int maxSum = a[0];
        int localSum = a[0];
        for (int i = 1; i < N; i++) {
            localSum = Math.max(a[i] + localSum, a[i]);
            maxSum = Math.max(maxSum, localSum);
        }
        return maxSum;
    }
}

package com.aiyyatti.algorithms.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubArray {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        TestCase.assertEquals(12, maxProduct(new int[]{-2, 1, -2, -6}));
    }

    @Test
    public void simpleTest2() {
        TestCase.assertEquals(840, maxProduct(new int[]{-2, 1, -2, -6, 5, -7}));
    }

    @Test
    public void simpleTest3() {
        TestCase.assertEquals(210, maxProduct(new int[]{-2, 1, -2, 0, -6, 5, -7}));
    }

    public int maxProduct(int[] a) {
        int max = a[0];
        int localMax = 1;
        int localMin = 1;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int interimMin = min(localMin * a[i], localMax * a[i], a[i]);
            int interimMax = max(localMin * a[i], localMax * a[i], a[i]);
            localMin = interimMin;
            localMax = interimMax;
            max = Math.max(localMax, max);
            if (localMin >= 0) localMin = 1;
            if (localMax <= 0) localMax = 1;
        }
        return max;
    }

    public int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public int min(int a, int b, int d) {
        return Math.min(Math.min(a, b), d);
    }
}

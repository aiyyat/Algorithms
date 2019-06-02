package com.aiyyatti.algorithms.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

public class BestTimeToBuyAndSellStockII {
    boolean isDebug = true;

    @Test
    public void leetTest() {
        int[] input = {7, 1, 5, 3, 6, 4};
        TestCase.assertEquals(7, bruteforce(input));
        TestCase.assertEquals(7, optimized(input));
    }

    @Test
    public void simple1Test() {
        int[] input = {0, 7};
        TestCase.assertEquals(7, bruteforce(input));
        TestCase.assertEquals(7, optimized(input));
    }

    @Test
    public void simple3Test() {
        int[] input = new int[0];
        TestCase.assertEquals(0, bruteforce(input));
        TestCase.assertEquals(0, optimized(input));
    }

    @Test
    public void simple2Test() {
        int[] input = {7};
        TestCase.assertEquals(0, bruteforce(input));
        TestCase.assertEquals(0, optimized(input));
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param a
     * @return
     */
    public int optimized(int[] a) {
        if (a == null || a.length == 0) return 0;
        int own = -1 * a[0], notOwn = 0;
        for (int i = 1; i < a.length; i++) {
            int tempOwn = Math.max(notOwn - a[i], own), tempNotOwn = Math.max(own + a[i], notOwn);
            own = tempOwn;
            notOwn = tempNotOwn;
        }
        return notOwn;
    }

    public int bruteforce(int[] a) {
        return bruteforce(a, 0, State.NOT_OWNING, 0, "");
    }

    /**
     * TODO: Remove Duplicate code.
     *
     * @param a
     * @param i
     * @param state
     * @param maxSum
     * @param path
     * @return
     */
    public int bruteforce(int[] a, int i, State state, int maxSum, String path) {
        if (i == a.length) {
            if (isDebug) System.out.println(path + " = " + maxSum);
            return maxSum;
        }
        int actedUpon;
        int skippingAct;
        if (state == State.OWNING) {
            actedUpon = bruteforce(a, i + 1, State.NOT_OWNING, maxSum + a[i], path + " selling at: " + a[i]);
            skippingAct = bruteforce(a, i + 1, State.OWNING, maxSum, path + " skipping " + a[i]);
        } else {
            actedUpon = bruteforce(a, i + 1, State.OWNING, maxSum - a[i], path + " buying at:" + a[i]);
            skippingAct = bruteforce(a, i + 1, State.NOT_OWNING, maxSum, path + " skipping " + a[i]);
        }
        return Math.max(actedUpon, skippingAct);
    }

    enum State {
        FIRST, OWNING, NOT_OWNING;
    }
}

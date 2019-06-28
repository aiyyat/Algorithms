package com.aiyyatti.algorithms.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        int[] a = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        TestCase.assertEquals(8, ownNotOwnApproach(a, fee));
        TestCase.assertEquals(8, peakValleyApproach(a, fee));
    }

    @Test
    public void simple1Test() {
        int[] a = new int[]{5, 2, 3, 1, 4};
        int fee = 2;
        TestCase.assertEquals(1, ownNotOwnApproach(a, fee));
        TestCase.assertEquals(1, peakValleyApproach(a, fee));
    }

    public int ownNotOwnApproach(int[] a, int fee) {
        int own = -1 * a[0];
        int notOwn = 0;
        int N = a.length;
        for (int i = 1; i < N; i++) {
            int tempOwn = Math.max(notOwn - a[i], own);
            int tempNotOwn = Math.max(own + a[i] - fee, notOwn);
            own = tempOwn;
            notOwn = tempNotOwn;
        }
        return notOwn;
    }

    public int peakValleyApproach(int[] a, int fee) {
        int N = a.length;
        int start = a[0];
        int txn = 0;
        for (int i = 1; i < N; i++) {
            if (start >= a[i] - 2) {
                if (a[i] < start) start = a[i];
            } else if (i == N - 1 || a[i + 1] < a[i]) {
                txn += a[i] - 2 - start;
                if (i < N - 1) {
                    start = a[i + 1];
                    i++;
                }
            }
        }
        return txn;
    }
}

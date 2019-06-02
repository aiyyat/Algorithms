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
        return Math.max(own, notOwn);
    }

    public int peakValleyApproach(int[] a, int fee) {
        int N = a.length;
        int boughtAt = a[0];
        int balance = 0;
        for(int i=1;i<N;i++){
            if(a[i]>a[i+1]) {
                balance+=boughtAt-a[i];
            }
        }
    }
}

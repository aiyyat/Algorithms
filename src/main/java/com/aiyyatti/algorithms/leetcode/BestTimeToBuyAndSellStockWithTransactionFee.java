package com.aiyyatti.algorithms.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    @Test
    public void simpleTest() {
        int[] a = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        TestCase.assertEquals(8, doBestTimeToBuyAndSellStockWithTransactionFee(a, fee));
    }

    public int doBestTimeToBuyAndSellStockWithTransactionFee(int[] a, int fee) {
        return -1;
    }
}

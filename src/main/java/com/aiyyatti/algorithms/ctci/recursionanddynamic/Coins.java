package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Coins: Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
 * pennies (1 cent), write code to calculate the number of ways of representing n cents.
 */
public class Coins {

    Logger logger = LoggerFactory.getLogger(Coins.class);
    private static final int[] COINS = new int[]{25, 10, 5, 1};

    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest1() {
        TestCase.assertEquals(4, numberOfWaysOfRepresending(10));
    }

    private int numberOfWaysOfRepresending(int N) {
        return numberOfWaysOfRepresending(0, N, "");
    }

    private int numberOfWaysOfRepresending(int index, int remainingAmount, String str) {
        if (index > COINS.length || remainingAmount < 0) return 0;
        if (remainingAmount == 0) {
            logger.info("{}", str);
            return 1;
        }
        int numOfWays = 0;
        for (int i = index; i < COINS.length; i++) {
            numOfWays += numberOfWaysOfRepresending(i, remainingAmount - COINS[i], str + " " + COINS[i]);
        }
        return numOfWays;
    }
}

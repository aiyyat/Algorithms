package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

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
        TestCase.assertEquals(9, numberOfWaysOfRepresending(10));
    }

    private int numberOfWaysOfRepresending(int N) {
        int[] memo = new int[N];
        Arrays.fill(memo, -1);
        return numberOfWaysOfRepresending(0, N, memo);
    }

    private int numberOfWaysOfRepresending(int sum, int N, int[] memo) {
        if (sum > N) return 0;
        else if (sum == N) {
            return 1;
        }
        if (memo[sum] == -1) {
            memo[sum] = numberOfWaysOfRepresending(sum + 25, N, memo) +
                    numberOfWaysOfRepresending(sum + 10, N, memo) +
                    numberOfWaysOfRepresending(sum + 5, N, memo) +
                    numberOfWaysOfRepresending(sum + 1, N, memo);
        }
        return memo[sum];
    }
}

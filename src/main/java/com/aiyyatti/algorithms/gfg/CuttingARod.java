package com.aiyyatti.algorithms.gfg;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time:
 * Todo:
 * Redo: Yes
 * Notes:
 */
public class CuttingARod {
    private static final Logger logger = getLogger(CuttingARod.class);
    Map<Integer, Integer> memo = new HashMap<>();

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testGFG() {
        int[][] input = new int[][]{
                new int[]{1, 1},
                new int[]{2, 5},
                new int[]{3, 8},
                new int[]{4, 9},
                new int[]{5, 10},
                new int[]{6, 17},
                new int[]{7, 17},
                new int[]{8, 20}
        };
        Assertions.assertThat(doCuttingARod(input, 8)).isEqualTo(22);
    }

    //////////////
    // SOLUTION //
    //////////////
    public int doCuttingARod(int[][] a, int K) {
        return doCuttingARod(a, 0, 0, 0, K);
    }

    public int doCuttingARod(int[][] a, int index, int value, int sum, int K) {
        if (memo.containsKey(sum)) return memo.get(sum);
        int N = a.length;
        int localMax = Integer.MIN_VALUE;
        for (int i = index; i < N; i++) {
            int newSum = a[i][0] + sum;
            int newValue = a[i][1] + value;
            if (newSum == K) localMax = max(localMax, newValue);
            else if (newSum < K) {
                int cuttingValue = doCuttingARod(a, i, newValue, newSum, K);
                localMax = max(localMax, cuttingValue);
            }
        }
        return localMax;
    }
}

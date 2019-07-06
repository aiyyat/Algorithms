package com.aiyyatti.algorithms.gfg;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Geek For Geeks - do applying memonization.
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
    }    ///////////////

    // TEST CASE //
    ///////////////
    @Test
    public void testGFG2() {
        int[][] input = new int[][]{
                new int[]{1, 3},
                new int[]{2, 5},
                new int[]{3, 8},
                new int[]{4, 9},
                new int[]{5, 10},
                new int[]{6, 17},
                new int[]{7, 17},
                new int[]{8, 20}
        };
        Assertions.assertThat(doCuttingARod(input, 8)).isEqualTo(24);
    }

    //////////////
    // SOLUTION //
    //////////////
    public int doCuttingARod(int[][] a, int K) {
        return doCuttingARod(a, 0, 0, 0, K);
    }

    /**
     * Just use the left over instead of sum and K, check if left over is >0
     *
     * @param a
     * @param index
     * @param value
     * @param sum
     * @param K
     * @return
     */
    public int doCuttingARod(int[][] a, int index, int value, int sum, int K) {
        if (memo.containsKey(sum)) return memo.get(sum)+value;
        int N = a.length;
        int localMax = Integer.MIN_VALUE;
        for (int i = index; i < N && K >= a[i][0] + sum; i++) {
            int newSum = a[i][0] + sum;
            int newValue = a[i][1];
            if (newSum == K) localMax = max(localMax, newValue);
            else if (newSum < K) {
                localMax = max(localMax, doCuttingARod(a, i, newValue, newSum, K));
            }
        }
        System.out.printf("sum:%s value:%s \n", sum, localMax);
        memo.put(sum, localMax);
        return localMax + value;
    }
}

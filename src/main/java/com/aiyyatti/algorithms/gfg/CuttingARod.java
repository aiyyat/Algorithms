package com.aiyyatti.algorithms.gfg;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;
import static org.assertj.core.api.Assertions.assertThat;
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
        assertThat(doCuttingARod(input, 8)).isEqualTo(22);
    }
    
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
        assertThat(doCuttingARod(input, 8)).isEqualTo(24);
    }

    //////////////
    // SOLUTION //
    //////////////
    public int doCuttingARod(int[][] a, int K) {
        return doCuttingARod(a, 0, 0, K);
    }

    /**
     * Just use the left over instead of sum and K, check if left over is >0
     *
     * @param a
     * @param index
     * @param value
     * @param leftOver
     * @return
     */
    public int doCuttingARod(int[][] a, int index, int value, int leftOver) {
        if (memo.containsKey(leftOver)) return memo.get(leftOver) + value;
        int N = a.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = index; i < N; i++) {
            int nowLeftOver = leftOver - a[i][0];
            if (nowLeftOver == 0) maxVal = max(maxVal, a[i][1]);
            else if (nowLeftOver > 0) {
                maxVal = max(maxVal, doCuttingARod(a, i, a[i][1], nowLeftOver));
            }
        }
        logger.info("When leftOver is:{} the best value is:{} \n", leftOver, maxVal);
        memo.put(leftOver, maxVal);
        return maxVal + value;
    }
}

package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview. 17.8
 * Time:
 * Todo:
 * Redo: Yes
 * Notes: like contiguous? think again - sequence is not contiguous.
 */
public class CircusTower {
    private static final Logger logger = getLogger(CircusTower.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest1() {
        assertThat(doCircusTower(new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{4, 1},
                new int[]{5, 4},
                new int[]{3, 7},
                new int[]{7, 6},
                new int[]{6, 5}
        })).isEqualTo(5);
    }

    //////////////
    // SOLUTION //
    //////////////
    public int doCircusTower(int[][] a) {
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int N = a.length;
        for (int i = 0; i < N; i++) logger.debug(Arrays.toString(a[i]));
        int tallest = 1;
        int[] memo = new int[N];
        memo[0] = 1;
        for (int i = 1; i < N; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (a[i][1] > a[j][1]) max = Math.max(max, memo[j] + 1);
            }
            tallest = Math.max(tallest, memo[i] = max);
        }
        return tallest;
    }
}

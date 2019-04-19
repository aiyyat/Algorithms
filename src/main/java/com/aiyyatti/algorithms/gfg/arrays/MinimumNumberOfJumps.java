package com.aiyyatti.algorithms.gfg.arrays;

import org.junit.Test;

/**
 * https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 */
public class MinimumNumberOfJumps {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        System.out.println(doMinimumNumberOfJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
    }

    public String doMinimumNumberOfJumps(int[] a) {
        int N = a.length;
        int[] result = doMinimumJumps(a);
        int i = a.length - 1;
        StringBuilder sb = new StringBuilder("");
        while (i > 0) {
            sb.insert(0, String.format("%s ", a[result[i]]));
            i = result[i];
        }
        return sb.toString();
    }

    public int[] doMinimumJumps(int[] a) {
        int N = a.length;
        int[] jumps = new int[N];
        int[] from = new int[N];
        for (int i = 1; i < N; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (a[j] + j >= i) {
                    int jumpsTillNow = jumps[j] + 1;
                    if (minSteps > jumpsTillNow) {
                        from[i] = j;
                        minSteps = jumpsTillNow;
                    }
                }
            }
            jumps[i] = minSteps;
        }
        return from;
    }
}

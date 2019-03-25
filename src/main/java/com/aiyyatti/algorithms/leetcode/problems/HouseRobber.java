package com.aiyyatti.algorithms.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    @Test
    public void simpleTest() {
        TestCase.assertEquals(6, stealPattern(new int[]{2, 1, 1, 2, 1, 2, 1}));
    }

    public int stealPattern(int[] a) {
        if (a.length == 0) return 0;
        int N = a.length;
        int[] notSteal = new int[N];
        int[] steal = new int[N];
        notSteal[0] = 0;
        steal[0] = a[0];
        for (int i = 1; i < N; i++) {
            notSteal[i] = Math.max(steal[i - 1], notSteal[i - 1]);
            steal[i] = Math.max(a[i] + notSteal[i - 1], steal[i - 1]);
            System.out.printf("not %s steal %s\n", Arrays.toString(notSteal), Arrays.toString(steal));
        }
        return steal[N - 1];
    }
}

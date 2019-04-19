package com.aiyyatti.algorithms.ctci.moderate;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Smallest Difference: Given two arrays of integers, compute the pair of values (one value in each
 * array) with the smallest (non-negative) difference. Return the difference.
 * EXAMPLE
 * Input{1,3,15,11,2h{2~12~235,1~8}
 * Output 3. That is, the pair (11, 8).
 */
public class SmallestDifference {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void testSimple() {
        int[] a1 = new int[]{1, 3, 15, 11, 2};
        int[] a2 = new int[]{23, 127, 235, 19, 8};
        Assert.assertArrayEquals(new int[]{11, 8}, doSmallestDifference(a1, a2));
    }

    private int[] doSmallestDifference(int[] a1, int[] a2) {
        Arrays.sort(a1);
        Arrays.sort(a2);
        int notedDiff1 = 0, notedDiff2 = 0, p1 = 0, p2 = 0, maxDiff = Integer.MAX_VALUE;
        int N1 = a1.length, N2 = a2.length;
        while (p1 < N1 && p2 < N2) {
            int diff = a1[p1] - a2[p2];
            if (Math.abs(diff) < maxDiff) {
                maxDiff = Math.abs(diff);
                notedDiff1 = p1;
                notedDiff2 = p2;
            }
            if (diff < 0) p1++;
            else p2++;
        }
        return new int[]{a1[notedDiff1], a2[notedDiff2]};
    }
}

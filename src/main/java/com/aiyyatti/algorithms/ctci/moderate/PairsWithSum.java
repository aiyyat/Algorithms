package com.aiyyatti.algorithms.ctci.moderate;

import junit.framework.TestCase;
import org.junit.Test;

public class PairsWithSum {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        int[] input = new int[]{-2, -1, 0, 3, 5, 6, 7, 9, 13, 14, 15};
        int K = 12;
        TestCase.assertEquals(4, doPairsWithSum(input, K));
    }

    public int doPairsWithSum(int[] a, int K) {
        int N = a.length;
        int left = 0;
        int right = N - 1;
        int count = 0;
        while (left < right) {
            if (a[left] + a[right] == K) {
                System.out.printf("%s+%s\n", a[left], a[right]);
                count++;
                left++;
                right--;
            } else if (a[left] + a[right] > K) right--;
            else left++;
        }
        return count;
    }
}

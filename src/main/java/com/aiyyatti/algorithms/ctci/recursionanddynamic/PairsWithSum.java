package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import org.junit.Test;

import java.util.Arrays;

public class PairsWithSum {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest1() {
        System.out.println(doPairsWithSum(new int[]{2, 14, 16, 10, 6, 4, 8, 0, 12}, 16));
    }

    public int doPairsWithSum(int[] a, int S) {
        Arrays.sort(a);
        int left = 0;
        int N = a.length - 1;
        int right = N;
        int count = 0;
        while (left < right) {
            int sum = a[left] + a[right];
            if (sum == S) {
                System.out.println(a[left] + "+" + a[right]);
                count++;
            } else if (sum < S) {
                right = N + 1;
                left++;
            }
            right--;
        }
        return count;
    }
}

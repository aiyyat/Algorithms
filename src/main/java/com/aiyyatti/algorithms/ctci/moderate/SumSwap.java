package com.aiyyatti.algorithms.gfg;

import org.junit.Test;

import java.util.Arrays;

public class SumSwap {
    @Test
    public void simpleTest() {
        int[] a1 = new int[]{4, 1, 2, 1, 1, 2}; //11
        int[] a2 = {3, 6, 3, 3}; //15
        System.out.println(Arrays.toString(doSumSwap(a1, a2)));
    }

    public int[] doSumSwap(int[] a1, int[] a2) {
        int N1 = a1.length;
        int N2 = a2.length;
        int diff = 0;
        for (int i = 0; i < N1; i++) {
            diff += a1[i];
        }
        for (int i = 0; i < N2; i++) {
            diff -= a2[i];
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        int left = 0;
        int right = N2 - 1;
        while (left < N1 && right >= 0) {
            if (a2[left] + a1[right] == Math.abs(diff)) {
                return new int[]{a1[left], a2[right]};
            } else if (Math.abs(a1[left] - a2[right]) < Math.abs(diff)) left++;
            else right--;
        }
        return null;
    }
}

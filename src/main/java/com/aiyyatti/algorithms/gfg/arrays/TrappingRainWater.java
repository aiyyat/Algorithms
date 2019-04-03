package com.aiyyatti.algorithms.gfg.arrays;

/**
 * https://practice.geeksforgeeks.org/problems/trapping-rain-water/0
 */

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/trapping-rain-water/
 */
public class TrappingRainWater {
    @Test
    public void simpleTest1() {
        int[] container = {3, 0, 0, 2, 0, 4};
        TestCase.assertEquals(10, doTrappingRainWater(container));
    }

    @Test
    public void simpleTest2() {
        int[] container = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TestCase.assertEquals(6, doTrappingRainWater(container));
    }


    public int doTrappingRainWater(int[] a) {
        int N = a.length;
        int[] leftToRight = new int[N];
        int[] rightToLeft = new int[N];
        int quantity = 0;
        leftToRight[0] = a[0];
        rightToLeft[N - 1] = a[N - 1];
        for (int i = 1; i < N; i++) {
            leftToRight[i] = Math.max(leftToRight[i - 1], a[i]);
        }
        for (int i = N - 2; i >= 0; i--) {
            rightToLeft[i] = Math.max(rightToLeft[i + 1], a[i]);
        }
        System.out.println(Arrays.toString(leftToRight));
        System.out.println(Arrays.toString(rightToLeft));
        for (int i = 0; i < N; i++) {
            quantity += Math.min(leftToRight[i], rightToLeft[i]) - a[i];
        }
        return quantity;
    }
}


  package com.aiyyatti.algorithms.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 */
public class MaximumProductOfThreeNumbers {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        TestCase.assertEquals(1498, doMaximumProductOfThreeNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, -2, -7 - 100}, 3));
    }

    @Test
    public void simpleTest2() {
        TestCase.assertEquals(6, doMaximumProductOfThreeNumbers(new int[]{1, 2, 3}, 3));
    }

    @Test
    public void simpleTest3() {
        TestCase.assertEquals(943695360, doMaximumProductOfThreeNumbers(new int[]{722, 634, -504, -379, 163, -613, -842, -578, 750, 951, -158, 30, -238, -392, -487, -797, -157, -374, 999, -5, -521, -879, -858, 382, 626, 803, -347, 903, -205, 57, -342, 186, -736, 17, 83, 726, -960, 343, -984, 937, -758, -122, 577, -595, -544, -559, 903, -183, 192, 825, 368, -674, 57, -959, 884, 29, -681, -339, 582, 969, -95, -455, -275, 205, -548, 79, 258, 35, 233, 203, 20, -936, 878, -868, -458, -882, 867, -664, -892, -687, 322, 844, -745, 447, -909, -586, 69, -88, 88, 445, -553, -666, 130, -640, -918, -7, -420, -368, 250, -786}, 3));
    }

    @Test
    public void simpleTest4() {
        TestCase.assertEquals(948838896, doMaximumProductOfThreeNumbers(new int[]{-235, -218, 399, 291, -963, -197, -426, -453, -263, 570, 121, -923, -535, -371, 664, 840, 703, -594, -337, -785, 343, 398, 895, 492, -782, 601, 108, -293, -512, -350, -790, 689, 277, -707, -296, 432, -536, -67, -499, -577, 583, 640, -233, -415, 522, -596, -839, 392, 778, -346, -283, 386, 706, 374, 888, -856, -693, 125, -271, 27, 248, -569, 173, -456, -365, 582, -976, -420, 779, -286, -806, -546, 602, 475, -703, -592, -325, 413, 707, 602, 216, 311, 224, -300, 991, 285, -981, -632, 84, 576, -975, 703, 360, -720, -578, 634, 909, -798, 77, -691}, 3));
    }


    public int doMaximumProductOfThreeNumbers(int[] a, int K) {
        if (a.length < K) return -1;
        Arrays.sort(a);
        long max = 1;
        int N = a.length;
        long localMax = 1;
        for (int i = N - K; i < N; i++) {
            localMax *= a[i];
        }
        max = localMax;
        if (N >= K + 2) {
            for (int i = 0; i < K - 1; i += 2) {
                localMax = (a[i] * a[i + 1] * localMax) / (a[N - K + i] * a[N - K + i + 1]);
                max = Math.max(localMax, max);
            }
        }
        return (int) max;
    }
}

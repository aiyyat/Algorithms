package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time:
 * Todo:
 * Redo: Yes
 * Notes: Reherse the brute force.
 */
public class VolumeOfHistogram {
    private static final Logger logger = getLogger(VolumeOfHistogram.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest() {
        int[] input = new int[]{0, 1, 0, 3, 0, 1, 5, 0, 2, 0};
        System.out.println(findVolume(input, 0, input.length - 1));
    }

    //////////////
    // SOLUTION //
    //////////////
    public int findVolume(int[] a, int start, int end) {
        if (start >= end || (end - start < 2)) return 0;
        int max1 = start, max2 = start + 1;
        if (a[max1] < a[max2]) {
            max1 = start + 1;
            max2 = start;
        }
        for (int i = start + 1; i <= end; i++) {
            if (a[i] > a[max2]) {
                if (a[i] > a[max1]) {
                    max2 = max1;
                    max1 = i;
                } else max2 = i;
            }
        }
        int sum = 0;
        int to = Math.max(max1, max2);
        int from = Math.min(max1, max2);
        for (int i = from; i <= to; i++) {
            if (a[i] < a[max2])sum += a[max2] - a[i];
        }
        return sum + findVolume(a, start, from) + findVolume(a, to, end);
    }
}

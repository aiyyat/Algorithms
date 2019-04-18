package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;

import java.util.Arrays;

public class RandomSet {
    @Test
    public void simpleTest() {
        System.out.println(Arrays.toString(pickMlteratively(new int[]{1, 2, 3, 4, 5, 6, 7}, 6)));
    }

    int[] pickMlteratively(int[] original, int m) {
        int[] subset = new int[m];
        for (int i = 0; i < m; i++) {
            subset[i] = original[i];
        }

        /* Go through rest of original array. */
        for (int i = m; i < original.length; i++) {
            int k = rand(0, i);
            if (k < m) {
                subset[k] = original[i];
            }
        }

        return subset;
    }

    int rand(int lower, int higher) {
        return lower + (int) (Math.random() * (higher - lower + 1));
    }
}

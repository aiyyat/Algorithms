package com.aiyyatti.algorithms.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class JumpGameII {
    @Test
    public void simpleTest1() {
        assertEquals(0, bruteForce(new int[]{2}));
        assertEquals(0, optimised(new int[]{2}));
    }

    @Test
    public void simpleTest3() {
        assertEquals(1, bruteForce(new int[]{2, 1}));
        assertEquals(1, optimised(new int[]{2, 1}));
    }

    @Test
    public void simpleTest2() {
        assertEquals(2, bruteForce(new int[]{2, 3, 1, 1, 4}));
        assertEquals(2, optimised(new int[]{2, 3, 1, 1, 4}));
    }
    @Test
    public void simpleTest4() {
        assertEquals(3, bruteForce(new int[]{2, 0, 1, 1, 4}));
        assertEquals(3, optimised(new int[]{2, 0, 1, 1, 4}));
    }

    public int bruteForce(int[] a) {
        return bruteForce(a, 0, a.length - 1, 0);
    }
    // O(
    public int bruteForce(int[] a, int i, int target, int steps) {
        if (i >= target) return steps;
        int minimumSteps = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + a[i]; j++) {
            int output = bruteForce(a, j, target, steps + 1);
            minimumSteps = Math.min(minimumSteps, output);
        }
        return minimumSteps;
    }
    // O(N^2)
    public int optimised(int a[]) {
        int N = a.length;
        int aux[] = new int[N];
        Arrays.fill(aux, Integer.MAX_VALUE);
        aux[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= a[i] && (i + j) < N; j++) {
                aux[j + i] = Math.min(aux[i + j], aux[i] + 1);
            }
        }
        System.out.println(Arrays.toString(aux));
        return aux[N - 1];
    }
}

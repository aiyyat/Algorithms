package com.aiyyatti.algorithms.ctci.sortingandsearching;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class PeaksAndValleys {
    @Test
    public void simpleTest() {
        int[] input = {1, 2, 3, 0, 5, 4, 8, 6, 7, 9};
        doPeakAndValleysWithSort(input);
        assertEquals("[0, 2, 1, 4, 3, 6, 5, 8, 7, 9]", Arrays.toString(input));
    }

    public void doPeakAndValleysWithSort(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        for (int i = 1; i < N; i += 2) {
            swap(a, i - 1, i);
        }
    }

    public void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}

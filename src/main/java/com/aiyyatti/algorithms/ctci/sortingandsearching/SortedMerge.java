package com.aiyyatti.algorithms.ctci.sortingandsearching;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class SortedMerge {
    @Test
    public void simpleTest() {
        int[] a = new int[]{1, 5, 7, 9, -1, -1, -1, -1, -1, -1};
        int[] b = new int[]{2, 3, 4, 6, 8, 10};
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(doSortedMerge(a, b)));
    }

    @Test
    public void simple2Test() {
        int[] a = new int[]{1, 2, 3, 4, -1, -1, -1, -1, -1, -1};
        int[] b = new int[]{5, 6, 7, 8, 9, 10};
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(doSortedMerge(a, b)));
    }

    @Test
    public void simple3Test() {
        int[] a = new int[]{5, 6, 7, 8, 9, 10, -1, -1, -1, -1};
        int[] b = new int[]{1, 2, 3, 4};
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(doSortedMerge(a, b)));
    }

    public int[] doSortedMerge(int[] a, int[] b) {
        int bN = b.length - 1;
        int aOffset = a.length - 1;
        int aN = aOffset - bN - 1;
        int aptr = aN;
        int bptr = bN;
        while (true) {
            if (aptr < 0 && bptr < 0) break;
            else if (aptr < 0) while (bptr >= 0) a[aOffset--] = b[bptr--];
            else if (bptr < 0) while (aptr >= 0) a[aOffset--] = a[aptr--];
            else if (a[aptr] > b[bptr]) a[aOffset--] = a[aptr--];
            else a[aOffset--] = b[bptr--];
        }
        return a;
    }
}

package com.aiyyatti.algorithms.ctci.sortingandsearching;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class SortedMerge {
    @Test
    public void simpleTest() {
        int[] a = new int[]{1, 5, 7, 9};
        int[] b = new int[]{2, 3, 4, 6, 8, 10};
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(doSortedMerge(a, b)));
    }

    @Test
    public void simple2Test() {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{5, 6, 7, 8, 9, 10};
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(doSortedMerge(a, b)));
    }
    @Test
    public void simple3Test() {
        int[] b = new int[]{1, 2, 3, 4};
        int[] a = new int[]{5, 6, 7, 8, 9, 10};
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(doSortedMerge(a, b)));
    }

    public int[] doSortedMerge(int[] a, int[] b) {
        int bN = b.length;
        int aN = a.length;
        int[] o = new int[aN + bN];
        int aptr = 0;
        int bptr = 0;
        int offset = 0;
        while (true) {
            if (aptr >= aN) {
                System.arraycopy(b, bptr, o, offset, bN - bptr);
                return o;
            } else if (bptr >= bN) {
                System.arraycopy(a, aptr, o, offset, aN - aptr);
                return o;
            } else if (a[aptr] > b[bptr]) o[offset++] = b[bptr++];
            else o[offset++] = a[aptr++];
        }
    }
}
